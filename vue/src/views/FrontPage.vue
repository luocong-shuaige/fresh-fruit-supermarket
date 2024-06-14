<template>
<div class="front-page-container">
  <div class="front-page">
    <goods-sourse2 :cgoods="goods" @handleSearch="handleSearch"></goods-sourse2>
    <pagination @item-click="pageClick" :cUrl="url"
      :cTotal="total" :cPageSize="pageSize"></pagination>
  </div>
  <div class="right-info">
    <div class="free-btn">
      <el-button type="success" style="background-color: rgb(9,93,227);" @click="toPublish">免费发布信息</el-button>   
      <!-- <img src="../assets/img/fabuxinxi2.png" @click="toPublish">    -->
    </div>
    <div class="top-info">
      <div style="font-size:18px"><strong>近期热门信息</strong></div>
      <div class="item-info" v-for="(item,index) in goodsTopics" :key="index" @click="handleDetail(item)">{{index+1}}、{{item.content}}</div>  
    </div>
  </div>
</div>

</template>
<script>
import { selectAllPage,selectGoodsPage } from "../api/order";
import GoodsSourse2 from "../components/GoodsSource2.vue";
import Pagination from "../components/Pagination.vue";
export default {
  data() {
    return {
      goods: [],
      goodsTopics:[],
      total: 0,
      pageSize: 30,
      url: "/order/All/",
      searchValue:'',
      goodsCount2: sessionStorage.getItem("/order/All/pageCode")
        ? sessionStorage.getItem("/order/All/pageCode")
        : 1,
    };
  },
  mounted() {
    this.getData()
    this.getTopicData()
  },
  methods: {
    getData(){
      this.$store.commit("updateActiveIndex", "1");
        selectAllPage({
          keys: this.searchValue,
          pageNum: this.goodsCount2,
        }).then((res) => {
			console.log(res);
          if (res.flag == true) {
            this.goods = res.data.records;
            this.total = res.data.total;
          } else {
            // alert(res.data.data);
          }
        });
    },
    getTopicData(){
      selectGoodsPage({
        pageNum: '1',
        keys:''
      }).then((res) => {
        if (res.flag == true) {
          let tmp = res.data.records;
          tmp.forEach((e,i) => {
            if(i<10){
              this.goodsTopics.push(e)
            }
          })
          // this.goods = res.data.list;
          // this.total = res.data.total;
        } else {
          // alert(res.data.data);
        }
      });
    },
    pageClick(item) {
      this.goods = item;
    },
    // 发布信息
    toPublish(){
      if(localStorage.getItem('token')){
        this.$router.push("/home/addmessage/publishgoods").catch((err) => err);
      }else{
        this.$router.push(`/login`).catch((err) => err);
      }
    },
    handleSearch(val){
      this.searchValue = val
      this.getData()
    },
    handleDetail(item){
      this.$store.commit("updateOrderId", item.orderId);
      this.$router.push(`/home/details?orderId=${item.orderId}`).catch((err) => err);
    }
  },
  components: {
    Pagination,
    GoodsSourse2,
  },
};
</script>

<style lang="less" scoped>
.front-page-container{
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  width: 1100px;
  margin: 10px auto;
}
.front-page {
  width: 780px;
  margin: 0 auto;
}
.item-info{
  line-height: 25px;
  cursor: pointer;
  &:hover{
    color: #035D1C;
    text-decoration: underline;
  }
}
.right-info{
  padding: 10px 20px;
  height: 1000px;
  width: 300px;
  min-height: 360px;
  background-color: #fff;
  .free-btn{
    text-align: center;
    cursor: pointer;
  }
  .top-info{
    font-size: 12px;
    margin-top: 20px;
  }
}
</style>