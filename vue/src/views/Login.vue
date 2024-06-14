<template>
  <div class="login-box">
    <div class="login">
      <div class="header">
        <!-- <a href="/">
        <img src="/public/img/logo3.png" alt="" />
      </a> -->
        <!-- <h1>用户登录</h1> -->
      </div>
      <div id="login_form">
        <div class="form-group">
          <label for="username">帐号</label>
          <input
            type="text"
            class="form-control"
            id="username"
            name="username"
            placeholder="请输入账号"
            v-model="acount"
          />
        </div>
        <div class="form-group">
          <label for="">密码</label>

          <input
            type="password"
            class="form-control"
            id=""
            name="password"
            placeholder="密码"
            v-model="password"
          />
        </div>
        <div class="checkbox">
          <label> <input type="checkbox" />记住密码 </label>
        </div>
        <button class="btn btn-success btn-block" @click="loginBtn" style="background-color: rgb(9,93,227);">
          登录
        </button>
      </div>
      <div class="message">
        <p>没有账号? <router-link to="/register">立即注册</router-link></p>
      </div>
    </div>
  </div>
</template>

<script>
import { userLogin } from "../api/user";
export default {
  name: "Login",
  data() {
    return {
      acount: "",
      password: "",
    };
  },
  methods: {
    loginBtn() {
      userLogin({
        username: this.acount,
        password: this.password,
      })
        .then((res) => {
          if (this.acount == "") {
            alert("用户名不能为空");
            return;
          } else if (this.password == "") {
            alert("密码不能为空");
            return;
          } else {
            if (res.flag == true) {
              // 在Vuex中存储token
              this.$store.commit("setToken", res.data);

              this.$router.push("/home").catch((err) => err);
            } else {
              alert(res.message);
            }
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  created() {},
};
</script>

<style lang="less" scoped>
@import url("../../node_modules/bootstrap/dist/css/bootstrap.css");

.login-box {
  box-sizing: border-box;
  // width: 1897px;
  height: 100%;
  padding-top: 150px;
  background: url("../assets/img/login-jpg.jpg");
  background-size: 1897px 920px;
  .login {
    width: 500px;
    height: 300px;
    margin: 0 auto;
    color: #333;
    .header {
      height: 40px;
      text-align: center;
      h1 {
        font-size: 26px;
        margin: 0;
        color: white;
      }
    }
    #login_form {
      padding: 20px;
      margin-bottom: 15px;
      border: 1px solid #d8dee2;
      border-radius: 5px;
      background-color: #fff;
    }
    .message {
      padding: 10px;
      padding-bottom: 0;
      color: white;
      border: 1px solid #d8dee2;
      border-radius: 5px;
      text-align: center;
    }
  }
}
</style>
