<template>
    <v-container>
        <h3>File Upload Result: </h3>
        <div>
            <!-- <button @click="selectUploadFile()">이미지 선택</button> -->
            <label>Files
                <input type="file" id="files" ref="files" multiple v-on:change="handleFileUpload()">
            </label>
            <button v-on:click="submitFiles()">업로드!</button>
        </div>
    </v-container>
</template>

<script>
import axios from 'axios'
// import snakecaseKeys from 'snakecase-keys'
export default {
    name: 'FileUploadPage',
    data () {
        return {
            files: ''
        }
    },
    methods: {
        handleFileUpload () {
            this.files = this.$refs.files.files
        },
        submitFiles () {
            let formData = new FormData()
            for (var idx = 0; idx < this.files.length; idx++) {
                formData.append('fileList', this.files[idx])
            }
            axios.post('http://localhost:7777/file/uploadImg', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            })
            .then (res => {
                this.response = res.data
            })
            .catch (res => {
                this.response = res.message
            }) 
            alert('Processing Complete!')
        }
        /*
        selectUploadFile () {
            let multiFileElem = document.createElement('input')
            multiFileElem.id = 'image'
            multiFileElem.type = 'file'
            multiFileElem.accept = 'image/*'
            multiFileElem.multiple = true
            multiFileElem.click()
            multiFileElem.onchange = () => {
                var formData = new FormData()
                var idx = 0
                for (; idx < this.files.length; idx++) {
                    formData.append('fileList', this.files[idx])
                }
                axios.defaults.transformRequest = [(formData) => {
                    if (formData) {
                        return snakecaseKeys(formData, { deep: true })
                    }
                }, ...axios.defaults.transformRequest]
                console.log(formData)
                axios.post('http://localhost:7777/file/uploadImg', formData, {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                })
                .then (res => {
                    this.response = res.data
                })
                .catch (res => {
                    this.response = res.message
                }) 
                alert('Processing Complete!')
            }
        }
        */
    }
}
</script>