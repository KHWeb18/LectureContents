<template>
  <div>
    <router-link :to="{ name: 'CoverFlowPage' }" 
      class="nav-link" 
      active-class="active">CoverFlow
    </router-link>
    <router-link :to="{ name: 'AwesomeSwiperPage' }" 
      class="nav-link" 
      active-class="active">AwesomeSwiper
    </router-link>
    <router-link :to="{ name: 'ImageGalleryPage' }" 
      class="nav-link" 
      active-class="active">ImageGallery
    </router-link>
    <router-link :to="{ name: 'CalendarPage' }" 
      class="nav-link" 
      active-class="active">Calendar
    </router-link>
    <router-link :to="{ name: 'FileUploadPage' }" 
      class="nav-link" 
      active-class="active">FileUploadPage
    </router-link>
  </div>  
</template>
