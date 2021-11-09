<template>
    <div class="main">
        <div class="best">
            <h3>추천 앨범</h3>
            <slot name="best"></slot>
        </div>
        <div class="singer">
            <figure>
                <h3>{{ ran_album.singer_Name }}</h3>
                <img :src="ran_album.pic"/>
            </figure>
        </div>
        <div class="footer">
            <slot name="footer"></slot>
        </div>
    </div>
</template>

<script>

export default {
    props: ['ran_album']
}
</script>

<style scoped>

.main {
    border: 4px solid gray;
}

.best {
    border: 4px solid turquoise;
}

.singer {
    border: 4px solid purple;
}

figcaption, h3 {
    color: greenyellow;
    text-align: center;
    padding: 2px 0;
    width: 100%;
}
img {
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 60%;
}
.footer {
    bottom: 0px;
    color: white;
    background-color: teal;
    width: 100%;
    text-align: center;
}


</style>
