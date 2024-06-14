<!--专家指导-->
<template>
  <div class="home-guide-container">
    <div class="left-guide">
      <guide-source :cgoods="goods" :pageSize="pageSize" :url="url" :total="total" @handleSearch="handleSearch" @pageClick="pageClick"></guide-source>  
    </div>
    <div class="right-guide">
      <div class="btn-content" v-if="!$store.getters.isAdmin&&!$store.getters.isExpert">
        <a @click="AllExBtn" style="cursor: pointer;">在线问答</a> |
        <a @click="AllExBtn" style="cursor: pointer;">专家预约</a>
      </div>
      <div class="professioner-item">
        <div style="font-size:18px;display: flex;justify-content: space-between;">
          <strong>专家列表</strong> 
          <a style="font-size:12px;cursor: pointer;" @click="AllExBtn">更多专家>></a>
        </div>
        <div class="epert" v-for="(item,index) in expertArray" :key="index" :style="index===expertArray.length-1?'':'border-bottom: 1px dashed #f2f2f2;'">
          <!-- <img :src="$store.state.imgShowRoad + '/file/' + 'experta.png'" alt="" /> -->
          <div class="info">
            <div class="item-style">
              <div class="content">专家姓名：{{item.realName}}</div>
              <div class="content">职称：{{item.position}}</div>
            </div>
            <div class="item-style">
              <div class="content">从事专业：{{item.profession}}</div>
              <div class="content">电话：{{item.phone}}</div>   
            </div>    
            <div class="item-content">单位：{{item.belong}}</div>
            <div class="item-btn">
              <div class="btn-item" @click="handleQuestion(item)" v-if="!$store.getters.isAdmin&&!$store.getters.isExpert">去提问</div>
              <div class="btn-item" @click="handleAppointment(item)" v-if="!$store.getters.isAdmin&&!$store.getters.isExpert">去预约</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { selectQuestions,selectExpert } from "../api/order";
import GuideSource from "../components/GuideSource.vue";

export default {
  data() {
    return {
      goods: [],
      total: 0,
      searchValue:'',
      pageSize: 30,
      url: "/order/goods/",
      expertCount:1,
      guideCount: sessionStorage.getItem("/order/goods/pageCode")
        ? sessionStorage.getItem("/order/goods/pageCode")
        : 1,
      expertArray:[]
    };
  },
  created() {
    if (this.$store.state.token == "") {
      alert;
    }
    this.$store.commit("updateActiveIndex", "5");
    this.getData()
    this.getExpertData()
  },
  methods: {
    pageClick(item) {
      this.goods = item;
    },
    AllExBtn() {
      this.$router.push("/home/allExpert").catch((err) => err);
    },
    handleSearch(val){
      this.searchValue = val
      this.getData()
    },
    getData(){
      selectQuestions({
        pageNum: this.guideCount,
        keys:this.searchValue
      }).then((res) => {
		  console.log(res);
        if (res.flag == true) {
          this.goods = res.data.records;
          this.total = res.data.total;
        } else {
          // alert(res.message);
        }
      }).catch(err=>{
        console.log(err)
      })
    },
    getExpertData(){
      selectExpert({
        pageNum: this.expertCount,
        keys:this.searchValue
      }).then(res => {
		   console.log(res);
        if(res.flag == true){
          this.expertArray = res.data.records;
        }else{
          this.$message.error(res.message);
        }
      }).catch(err=>{
        console.log(err)
      })
    },
    handleQuestion(item){
      if(localStorage.getItem('token')){
        this.$router.push(`/home/question?id=${item.userName}`).catch((err) => err);
      }else{
        this.$message.error('请先登录')
        this.$router.push(`/login`).catch((err) => err);
      } 
    },
    handleAppointment(item){
      if(localStorage.getItem('token')){
        this.$router.push(`/home/appointment?id=${item.userName}`).catch((err) => err);
      }else{
        this.$message.error('请先登录')
        this.$router.push(`/login`).catch((err) => err);
      } 
    }
  },
  components: {
    GuideSource,
  },
};
</script>

<style lang="less" scoped>
.home-guide-container{
  width: 1100px;
  margin: 0 auto;
  display: flex;
  justify-content: space-between;
  .left-guide {
    margin-top: 10px;
  }
  .right-guide{
    margin-top: 10px;
    .btn-content{
      background-color: white;
      width:350px;
      font-size:16px;
      text-align: center;
      font-size:18px; 
      font-weight:bold;
      height: 40px;
      line-height: 40px;
    }
    .professioner-item{
      background-color: #fff;
      width:350px;
      font-size:12px;
      padding: 10px 20px;
      margin-top: 10px;
    }
  }
}


.epert {
  min-height: 80px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin-top: 20px;
  align-items: center;
  // padding: 10px 10px;
  img {
    width: 80px;
    height: 80px;
    margin-right: 10px;
    border-radius: 6px;
  }
  .item-style{
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }
  p {
    margin: 5px;
  }
  .content{
    color:#333;
    font-size:12px;
    font-style:normal;
    width: 120px;
    line-height: 25px;
  }
  .item-content{
    width: 220px;
    line-height: 25px;
    /*超出的部分隐藏*/
    overflow: hidden;
    /*文字用省略号替代超出的部分*/
    text-overflow: ellipsis;
    word-break: break-all;
    /*弹性伸缩盒子模型显示*/
    display: -webkit-box;
    /*限制在一个块元素显示文本的行数*/
    -webkit-line-clamp: 2;
    /*设置或检索伸缩盒对象的子元素排列方式*/
    -webkit-box-orient: vertical;
  }
  .item-btn{
    display: flex;
    flex-direction: row;
    justify-content: flex-end;
    margin-bottom: 10px;
    margin-right: 10px;
    color: #67C23A;
    .btn-item{
      margin-left: 10px;
      cursor: pointer;
      &:hover{
        text-decoration: underline;
        color: #035D1C;
      }
    }
  }
}
</style>