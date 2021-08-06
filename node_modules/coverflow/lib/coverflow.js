'use strict';

require('./raf.lib.js');
require('./wheelEvent.lib.js');
var createStyleSheet = require('./createStyleSheet.js');

var count, images, dim, offset, center, angle, dist, shift,
    pressed, reference, amplitude, target, velocity, timeConstant,
    xform, frame, timestamp, ticker, oldActiveIndex, starttimestamp, tapMaxConstant,
    onActiveClick, onChange, view, viewHeight;

function initialize(container, options) {
  options = options || {};
  pressed = false;
  oldActiveIndex = 0;
  timeConstant = options.timeConstant || 250; // ms
  tapMaxConstant = options.tapMaxConstant || 150; // ms
  offset = target = 0;
  reference = amplitude = velocity = frame = undefined;
  angle = options.angle || -60;
  dist = options.angle || -150;
  shift = options.shift || 10;
  onActiveClick = options.onActiveClick || function () {};
  onChange = options.onChange || function () {};
  container = (typeof container === 'string') ? document.getElementById(container) : container;
  count = container.children.length;
  images = [];
  while (images.length < count) images.push(container.children.item(images.length));
  var maxHeight = 0, maxWidth = 0;
  var tagName = options.tagName || images[0].tagName;
  images.map(function (el, index) {
    el.onclick = function (e) {
      flowTo(index);
      e.preventDefault();
      e.stopPropagation();
    };
    maxHeight = maxHeight > el.scrollHeight ? maxHeight : el.scrollHeight;
    maxWidth = maxWidth > el.style.width ? maxWidth : el.style.width;
  });
  maxHeight = options.maxHeight || maxHeight;
  maxWidth = options.maxWidth || maxWidth;
  container.className += ' coverflow';
  container.style.height = maxHeight * 1.1;
  createStyleSheet(tagName, maxHeight, maxWidth);
  images.map(function (el, index) {
    maxHeight = maxHeight > el.scrollHeight ? maxHeight : el.scrollHeight;
    maxWidth = maxWidth > el.scrollWidth ? maxWidth : el.scrollWidth;
  });
  viewHeight = maxHeight * 1.1;
  dim = maxWidth;
  view = container;
  scroll(offset);
  setupEvents(container);
}

function setupEvents() {
  document.addEventListener('keydown', handleKey);
  window.addEventListener('resize', scroll);
  if (view) {
    if (typeof window.ontouchstart !== 'undefined') {
      view.addEventListener('touchstart', tap);
      view.addEventListener('touchmove', drag);
      view.addEventListener('touchend', release);
      view.addEventListener('touchcancel', release);
    }
    addWheelListener(view, wheel);
    view.addEventListener('mousedown', tap);
    view.addEventListener('mousemove', drag);
    view.addEventListener('mouseup', release);
  }
}

function unmount() {
  document.removeEventListener('keydown', handleKey);
  window.removeEventListener('resize', scroll);
}

function wheel(e) {
  if (e.deltaY > 0) setActive(getActiveIndex() + 1);
  else if (e.deltaY < 0) setActive(getActiveIndex() - 1);
  changed(getActiveIndex());
}

function xpos(e) {
  // touch event
  if (e.targetTouches && (e.targetTouches.length >= 1)) {
    return e.targetTouches[0].clientX;
  }

  // mouse event
  return e.clientX;
}

function wrap(x) {
  return (x >= count) ? (x % count) : (x < 0) ? wrap(count + (x % count)) : x;
}

function scroll(x) {
  var i, half, delta, dir, tween, el, alignment;

  offset = (typeof x === 'number') ? x : offset;
  center = Math.floor((offset + dim / 2) / dim);
  delta = offset - center * dim;
  dir = (delta < 0) ? 1 : -1;
  tween = -dir * delta * 2 / dim;

  alignment = 'translateX(' + (view.clientWidth - dim) / 2 + 'px) ';
  alignment += 'translateY(' + (viewHeight - dim) / 2 + 'px)';

  // center
  el = images[wrap(center)];
  if (el) {
    el.style[xform] = alignment +
      ' translateX(' + (-delta / 2) + 'px)' +
      ' translateX(' + (dir * shift * tween) + 'px)' +
      ' translateZ(' + (dist * tween) + 'px)' +
      ' rotateY(' + (dir * angle * tween) + 'deg)';
    el.style.zIndex = 0;
    el.style.opacity = 1;
  }

  half = count >> 1;
  for (i = 1; i <= half; ++i) {
    // right side
    el = images[wrap(center + i)];
    if (el) {
      el.style[xform] = alignment +
        ' translateX(' + (shift + (dim * i - delta) / 2) + 'px)' +
        ' translateZ(' + dist + 'px)' +
        ' rotateY(' + angle + 'deg)';
      el.style.zIndex = -i;
      el.style.opacity = (i === half && delta < 0) ? 1 - tween : 1;
    }

    // left side
    el = images[wrap(center - i)];
    if (el) {
      el.style[xform] = alignment +
        ' translateX(' + (-shift + (-dim * i - delta) / 2) + 'px)' +
        ' translateZ(' + dist + 'px)' +
        ' rotateY(' + -angle + 'deg)';
      el.style.zIndex = -i;
      el.style.opacity = (i === half && delta > 0) ? 1 - tween : 1;
    }
  }

  // center
  el = images[wrap(center)];
  if (el) {
    el.style[xform] = alignment +
      ' translateX(' + (-delta / 2) + 'px)' +
      ' translateX(' + (dir * shift * tween) + 'px)' +
      ' translateZ(' + (dist * tween) + 'px)' +
      ' rotateY(' + (dir * angle * tween) + 'deg)';
    el.style.zIndex = 0;
    el.style.opacity = 1;
  }
}

function track() {
  var now, elapsed, delta, v;

  now = Date.now();
  elapsed = now - timestamp;
  timestamp = now;
  delta = offset - frame;
  frame = offset;

  v = 1000 * delta / (1 + elapsed);
  velocity = 0.8 * v + 0.2 * velocity;
}

function autoScroll() {
  var elapsed, delta;

  if (amplitude) {
    elapsed = Date.now() - timestamp;
    delta = amplitude * Math.exp(-elapsed / timeConstant);
    if (delta > 4 || delta < -4) {
      scroll(target - delta);
      requestAnimationFrame(autoScroll);
    } else  {
      scroll(target);
      changed(getActiveIndex());
    }
  }
}

function tap(e) {
  pressed = true;
  reference = xpos(e);

  velocity = amplitude = 0;
  frame = offset;
  timestamp = Date.now();
  starttimestamp = timestamp;
  clearInterval(ticker);
  ticker = setInterval(track, 50);

  // allow touch devices to handle click event but dont allow dragging on desktops
  if (e.type == 'mousedown') e.preventDefault();
  e.stopPropagation();
  // allow touch devices to handle click event but dont allow dragging on desktops
  if (e.type == 'mousedown') return false;
}

function drag(e) {
  var x, delta;
  if (pressed) {
    x = xpos(e);
    delta = reference - x;
    if (delta > 2 || delta < -2) {
      reference = x;
      scroll(offset + delta);
    }
  }
  e.preventDefault();
  e.stopPropagation();
  return false;
}

function release(e) {
  pressed = false;

  clearInterval(ticker);
  target = offset;
  timestamp = Date.now();
  if (velocity > 10 || velocity < -10) {
    amplitude = 0.9 * velocity;
    target = offset + amplitude;
    target = Math.round(target / dim) * dim;
    amplitude = target - offset;
    requestAnimationFrame(autoScroll);

    e.preventDefault();
    e.stopPropagation();
    return false;
  } else if (timestamp - starttimestamp > tapMaxConstant) { // Snap to nearest element
    target = Math.round(target / dim) * dim;
    amplitude = target - offset;
    requestAnimationFrame(autoScroll);

    e.preventDefault();
    e.stopPropagation();
    return false;
  } else {
    var newtarget = Math.round(target / dim) * dim;
    amplitude = newtarget - target;
    target = newtarget;
    requestAnimationFrame(autoScroll);
  }
}

function handleKey(e) {
  if (!pressed && (target === offset)) {
    // Space or PageDown or RightArrow or DownArrow
    if ([32, 34, 39, 40].indexOf(e.which) >= 0) {
      target = offset + dim;
    }
    // PageUp or LeftArrow or UpArrow
    if ([33, 37, 38].indexOf(e.which) >= 0) {
      target = offset - dim;
    }
    if (offset !== target) {
      amplitude = target - offset;
      timestamp = Date.now();
      requestAnimationFrame(autoScroll);
      return true;
    }
  }
}

function flowTo(to) {
  var centerIndex = getActiveIndex();
  if (to == centerIndex) {
    onActiveClick(centerIndex);
  } else {
    var offsetPosition;
    if (to - centerIndex > (count - 1)/2) offsetPosition = (to - centerIndex) - count;
    else if (to - centerIndex <= -(count - 1)/2) offsetPosition = (to - centerIndex) + count;
    else offsetPosition = to - centerIndex;
    target = offset + offsetPosition * dim;
    amplitude = target - offset;
    timestamp = Date.now();
    requestAnimationFrame(autoScroll);
    return true;
  }
}

function setActive(to) {
  target = dim * to;
  scroll(dim * to);
}

function getActiveIndex() {
  var centerIndex = center % count;
  while (centerIndex < 0) centerIndex += count;
  return centerIndex;
}

function getActiveElement() {
  return images[getActiveIndex()];
}

function getActiveId() {
  return images[getActiveIndex()].id;
}

function changed(to) {
  if (oldActiveIndex != to) {
    onChange(to, oldActiveIndex);
    oldActiveIndex = to;
  }
}

xform = 'transform';
['webkit', 'Moz', 'O', 'ms'].every(function (prefix) {
  var e = prefix + 'Transform';
  if (typeof document.body.style[e] !== 'undefined') {
    xform = e;
    return false;
  }
  return true;
});

module.exports = {
  initialize: initialize,
  flowTo: flowTo,
  setActive: setActive,
  getActiveId: getActiveId,
  getActiveElement: getActiveElement,
  getActiveIndex: getActiveIndex,
  unmount: unmount,
};
