<template>
    <div class="todo">
        <li>
            <span v-if="!isEditing" v-on:dblclick="handleDoubleClick">
                {{ todoItem.content }}
            </span>
            <input v-else type="text" ref="content" 
                    v-bind:value="todoItem.content"
                    v-on:blur="handleBlur"
                    v-on:keydown.enter="editTodo"/>

            <input type="checkBox" v-bind:checked="todoItem.done"
                v-on:change="toggleTodoStatus()"/>

            <button v-on:click="removeTodo">지우기</button>
            <!-- ref는 어떤 용도로 사용된건가요??
            ref자체는 content를 가르킨다.-->

            <!-- checked는 변화를 감지한다. 값이 변화하면 작동한다 -->

            <!-- blur는 마우스 포커스를 뗐을 때 발동 -->
        </li>
    </div>        
</template>

<script>

export default {
        name: 'TodoItem',
        props: {
            todoItem: {
                type: Object
        },
        editingId: {
            type: Number
        }
    },
    computed: {
        isEditing() {
            return this.todoItem.id === this.editingId
        } 
        //질문 1.

        //더블클릭해서 setEditingId가 실행되면 mutation에 있는 editingId가 그대로 id값을 받아 todoItem.id와 eiditingId는 같은값을 가지게되어,
        //isEditing은 true가 나오게된다.
        //isEditing이 true이면 v-if에서 !isEditing이 false가 되므로 v-else에 있는 text 수정바가 나타나게되고 blur를 통해 커서를 떼게되면,
        //resetEditingId가 발동해 mutation을 통해 state의 editingId값을 0으로 만들게된다.
        //그러면 리스트된 todoItem들 모두 isEiditing의 값이 false가 되므로 v-if는 true가 나오게된다.
        //v-if가 true이므로 일반적인 todoItem.content값이 출력된다.

        //흐름이 헷갈려서 적어보면서 이해를 해보고자했는데요. 제가 쓴게 맞는지? 확인좀 부탁드립니다. 
    },
    methods: {
        removeTodo() {
            const id = this.todoItem.id
            this.$emit('removeTodo', id)
        },
        editTodo(event) {
            const id = this.todoItem.id
            const content = event.target.value.trim()

            if(content.length <= 0) {
                return false
            }
            this.$emit('editTodo', content, id)
            
            //위 refs blur()가 무슨뜻?
            //커서를 없앤다는 뜻
        },
        handleBlur() {
            this.$emit('resetEditingId')
            console.log('handleBlur()')
            //커서를 뗐을 때 반응
            //마우스를 떼면 editingId가 다시 0으로 돌아온다.
        },
        toggleTodoStatus() {
            const id = this.todoItem.id
            console.log('toggleTodoStatus() - id: ' + id)

            this.$emit('toggleTodoStatus', id)
        },
        handleDoubleClick() {
            const { id } = this.todoItem
            console.log('handleDoubleClick() - id: ' + JSON.stringify(id))

            this.$emit('setEditingId', id)
            this.$nextTick(() => {
                this.$refs.content.focus()
                //아주 짧은 sleep이라고 보면된다. 텀을 두는...
                //Thread의 sleep과 동일한 기능이다.

                //focus()는 더블클릭 시 텍스트 입력상자 안에 커서를 생성한다.
            })
        }
    }
}

</script>