<template>
    <div class="register-form">
      <h2>Register</h2>
      <form @submit.prevent="handleRegister">
        <div class="form-group">
          <label>Username:</label>
          <input 
            v-model="user.username" 
            type="text" 
            class="form-control" 
            required
          />
        </div>
        
        <div class="form-group">
          <label>Email:</label>
          <input 
            v-model="user.email" 
            type="email" 
            class="form-control" 
            required
          />
        </div>
  
        <div class="form-group">
          <label>Password:</label>
          <input 
            v-model="user.password" 
            type="password" 
            class="form-control" 
            required
          />
        </div>
  
        <button type="submit" class="btn btn-primary">Register</button>
        
        <div v-if="message" :class="['alert', successful ? 'alert-success' : 'alert-danger']">
          {{ message }}
        </div>
      </form>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    name: 'RegisterPage',
    data() {
      return {
        user: {
          username: '',
          email: '',
          password: ''
        },
        message: '',
        successful: false
      };
    },
    methods: {
      handleRegister() {
        axios.post('http://localhost:8080/api/auth/register', this.user)
          .then(response => {
            this.message = response.data;
            this.successful = true;
            setTimeout(() => {
              this.$router.push('/login');
            }, 2000);
          })
          .catch(error => {
            this.message = error.response.data;
            this.successful = false;
          });
      }
    }
  };
  </script>
  
  <style scoped>
  .register-form {
    max-width: 400px;
    margin: 0 auto;
    padding: 20px;
  }
  .form-group {
    margin-bottom: 15px;
  }
  .form-control {
    width: 100%;
    padding: 8px;
    margin-top: 5px;
  }
  .btn {
    width: 100%;
    padding: 10px;
    background-color: #4CAF50;
    color: white;
    border: none;
    cursor: pointer;
  }
  .alert {
    margin-top: 15px;
    padding: 10px;
    border-radius: 4px;
  }
  .alert-success {
    background-color: #d4edda;
    color: #155724;
  }
  .alert-danger {
    background-color: #f8d7da;
    color: #721c24;
  }
  </style>