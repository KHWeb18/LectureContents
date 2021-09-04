<template>
    <v-app id="inspire" style="background-color: #171717;">
        <v-app-bar
                app
                clipped-right
                color="#252525"
                dark style="margin: 100px;">
          
            <v-toolbar-title>다음 뉴스(MOVIE)</v-toolbar-title>
            <v-spacer></v-spacer>
            <slot name="menubar"></slot>
        </v-app-bar>

        <v-container>
            <v-content id="content">
                <slot name="content" class="font">
                </slot>
            </v-content>
        </v-container>

    </v-app>
</template>

<script>

</script>