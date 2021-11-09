<template>
  <div>
    <router-link :to="{ name: 'UnNamedSlotPage' }" 
      class="nav-link" 
      active-class="active">UnNamedSlot
    </router-link>
    <router-link :to="{ name: 'NamedSlotPage' }" 
      class="nav-link" 
      active-class="active">NamedSlot
    </router-link>
    <router-link :to="{ name: 'ScopedSlotPage' }" 
      class="nav-link" 
      active-class="active">ScopedSlot
      </router-link>
    <router-link :to="{ name: 'RecentSlotPage' }" 
      class="nav-link" 
      active-class="active">RecentSlot
    </router-link>
  </div>
</template>