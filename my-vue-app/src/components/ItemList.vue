<template>
    <div>
        <h1>Items</h1>
        <ul>
            <li v-for="item in items" :key="item.id">
                <span v-if="!isEditing(item.id)">{{ item.name }}</span>
                <input v-if="isEditing(item.id)" v-model="editedItemName" @keyup.enter="updateItem(item.id)" />
                <button v-if="!isEditing(item.id)" @click="startEditing(item.id, item.name)">Edit</button>
                <button @click="deleteItem(item.id)">Delete</button>
            </li>
        </ul>
        <input v-model="newItem" placeholder="Add new item" />
        <button @click="addItem">Add Item</button>
    </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'ItemList',
  data() {
        return {
            items: [],
            newItem: '',
            editingItemId: null,
            editedItemName: ''
        };
    },
    methods: {
        fetchItems() {
            axios.get('http://localhost:8080/api/items', { headers: {Authorization: localStorage.getItem('token')} })
                .then(response => {
                    this.items = response.data;
                })
                .catch(error => {
                    console.error('There was an error!', error);
                });
        },
        addItem() {
            axios.post('http://localhost:8080/api/items', { name: this.newItem }, { headers: {Authorization: `${localStorage.getItem('token')}`} })
                .then(response => {
                    this.items.push(response.data);
                    this.newItem = '';
                })
                .catch(error => {
                    console.error('There was an error adding the item!', error);
                });
        },
        deleteItem(id) {
            axios.delete(`http://localhost:8080/api/items/${id}`, { headers: {Authorization: `${localStorage.getItem('token')}`} })
                .then(() => {
                    this.items = this.items.filter(item => item.id !== id);
                })
                .catch(error => {
                    console.error('There was an error deleting the item!', error);
                });
        },
        startEditing(id, name) {
            this.editingItemId = id;
            this.editedItemName = name;
        },
        isEditing(id) {
            return this.editingItemId === id;
        },
        updateItem(id) {
            axios.put(`http://localhost:8080/api/items/${id}`, { name: this.editedItemName}, { headers: {Authorization: `${localStorage.getItem('token')}`} })
                .then(response => {
                    const index = this.items.findIndex(item => item.id === id);
                    if (index !== -1) {
                        this .items[index].name = response.data.name;
                    }
                    this.editingItemId = null;
                    this.editedItemName = '';
                })
                .catch(error => {
                    console.error('There was an error updating the item!', error);
                });
        }
    },
    mounted() {
        this.fetchItems();
    }
};
</script>