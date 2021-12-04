<template>
  <div>
    <router-link :to="{ name: 'StudentScorePage' }" 
        class="nav-link" 
        active-class="active">Student
    </router-link>
    <router-link :to="{ name: 'TriangleVuePage' }" 
        class="nav-link" 
        active-class="active">TriangleVue
    </router-link>
    <router-link :to="{ name: 'TriangleSpringPage' }" 
        class="nav-link" 
        active-class="active">TriangleSpring
    </router-link>
    <router-link :to="{ name: 'MemberJpaPage' }" 
        class="nav-link" 
        active-class="active">MemberJPA
    </router-link>
  </div>   
</template>