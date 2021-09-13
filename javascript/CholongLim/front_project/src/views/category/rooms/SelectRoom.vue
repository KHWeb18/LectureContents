<template>
  <div style="margin-top:3%; margin-bottom:3%;">
    <section class="cards-wrapper">
      <div class="card-grid-space">
        <router-link to="/room301">
        <a class="card" style="--bg-img: url(https://images.pexels.com/photos/7533766/pexels-photo-7533766.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260)">
          <div>
            <h1>#Room301</h1>
            <p>Modern 타입의 Cinzel만의 가족룸</p>
            <div class="tags">
              <div class="tag">#4인</div>
              <div class="tag">#가족</div>
              <div class="tag">#MODERN</div>
            </div>
          </div>
        </a>
        </router-link>
      </div>

      <div class="card-grid-space">
        <router-link to="/room302">
        <a class="card" style="--bg-img: url(https://images.pexels.com/photos/6782569/pexels-photo-6782569.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260)">
          <div>
            <h1>#Room302</h1>
            <p>Unique 타입의 Cinzel만의 가족룸</p>
            <div class="tags">
              <div class="tag">#4인</div>
              <div class="tag">#가족</div>
              <div class="tag">#UNIQUE</div>
            </div>
          </div>
        </a>
        </router-link>
      </div>

      <div class="card-grid-space">
        <router-link to="/room201">
        <a class="card" style="--bg-img: url(https://images.pexels.com/photos/7546712/pexels-photo-7546712.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260)">
          <div>
            <h1>#Room201</h1>
            <p>Yellow톤 컨셉의 Cinzel만의 커플룸</p>
            <div class="tags">
              <div class="tag">#2인</div>
              <div class="tag">#커플</div>
              <div class="tag">#YELLOW</div>
            </div>
          </div>
        </a>
        </router-link>
      </div>

      <div class="card-grid-space">
        <router-link to="/room202">
        <a class="card" style="--bg-img: url(https://images.pexels.com/photos/7546707/pexels-photo-7546707.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260)">
          <div>
            <h1>#Room202</h1>
            <p>BLUE톤 컨셉의 Cinzel만의 커플룸</p>
            <div class="tags">
              <div class="tag">#2인</div>
              <div class="tag">#커플</div>
              <div class="tag">#BLUE</div>
            </div>
          </div>
        </a>
        </router-link>
      </div>
    
    </section>
  </div>
</template>

<style lang="scss" scoped>
@import url('https://fonts.googleapis.com/css?family=Heebo:400,700|Open+Sans:400,700');
@import url('https://fonts.googleapis.com/css2?family=Nanum+Brush+Script&display=swap');



:root {
  --color: #3c3163;
  --transition-time: 0.5s;
}

* {
  box-sizing: border-box;
}


.cards-wrapper {
  display: grid;
  justify-content: center;
  align-items: center;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-gap: 1.5rem;
  padding: 4rem;
  margin: 0 auto;
  width: max-content;
}

.card {
  font-family: 'Heebo';
  --bg-filter-opacity: 0.5;
  background-image: linear-gradient(rgba(0,0,0,var(--bg-filter-opacity)),rgba(0,0,0,var(--bg-filter-opacity))), var(--bg-img);
  height: 20em;
  width: 15em;
  font-size: 1.5em;
  color: rgb(255, 255, 255);
  border-radius: 1em;
  padding: 1em;
  display: flex;
  align-items: flex-end;
  background-size: cover;
  background-position: center;
  transition: all, var(--transition-time);
  position: relative;
  overflow: hidden;
  text-decoration: none;
}

// .card:hover {
//   transform: rotate(0);
// }
@import url('https://fonts.googleapis.com/css2?family=Italiana&display=swap');
.card h1 {
  margin: 0;
  font-size: 1.5em;
  line-height: 1.2em;
  font-family: 'Italiana';
}
@import url('https://fonts.googleapis.com/css2?family=Gowun+Batang&display=swap');
.card p {
  font-size: 0.75em;
  font-family: 'Gowun Batang';
  margin-top: 0.5em;
  line-height: 2em;
}

.card .tags {
  display: flex;
}

.card .tags .tag {
  font-size: 0.75em;
  background: rgba(189, 164, 247, 0.5);
  border-radius: 0.3rem;
  padding: 0 0.5em;
  margin-right: 0.5em;
  line-height: 1.5em;
  transition: all, var(--transition-time);
}

.card:hover {
  // color: rgb(204, 192, 231);
  height: 410px;
  box-shadow: 20px 20px 40px 0px rgba(0,0,0,0.5);
}

.card:hover:before, .card:hover:after {
  transform: scale(1);
}


.info {
  font-size: 1.2em;
  display: flex;
  padding: 1em 3em;
  height: 3em;
}

.info img {
  height: 3em;
  margin-right: 0.5em;
}

.info h1 {
  font-size: 1em;
  font-weight: normal;
}


/* MEDIA QUERIES */
@media screen and (max-width: 1285px) {
  .cards-wrapper {
    grid-template-columns: 1fr 1fr;
  }
}

@media screen and (max-width: 500px) {
  .cards-wrapper {
    padding: 4rem 2rem;
  }
  .card {
    max-width: calc(100vw - 4rem);
  }
}

@media screen and (max-width: 450px) {
  .info {
    display: block;
    text-align: center;
  }
  .info h1 {
    margin: 0;
  }
}


</style>