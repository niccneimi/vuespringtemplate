<template>
    <div class="login-form">
      <h2>Login</h2>
      <form @submit.prevent="handleLogin">
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
          <label>Password:</label>
          <input 
            v-model="user.password" 
            type="password" 
            class="form-control" 
            required
          />
        </div>
  
        <button type="submit" class="btn btn-primary">Login</button>
        
        <div v-if="message" :class="['alert', successful ? 'alert-success' : 'alert-danger']">
          {{ message }}
        </div>
      </form>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    name: 'LoginPage',
    data() {
      return {
        user: {
          username: '',
          password: ''
        },
        message: '',
        successful: false
      };
    },
    methods: {
      handleLogin() {
        axios.post('http://localhost:8080/api/auth/login', this.user)
          .then(response => {
            const token = response.data;
            localStorage.setItem('token', token);
            this.message = 'Login successful!';
            this.successful = true;
            this.$router.push('/');
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
  .login-form {
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