<template>
  <div class="test">
      <div id="header">
        <router-link :to="{ name: 'BoardListPage' }"
                    class="nav-link"
                    active-class="active">
                BoardListPage
            </router-link>
            <router-link :to="{ name: 'MemberRegisterPage' }"
                    class="nav-link"
                    active-class="active">
                MemberRegisterPage
            </router-link>
      </div>
  </div>
</template>

<script>
  export default {
    name: 'Test',
    components: {
    },
  }
</script>
