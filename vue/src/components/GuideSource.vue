<template>
  <div class="goods-box3">
    <div class="search">
      <el-input v-model="searchValue" maxlength="100" clearable style="width:290px;"/>
      <img src="../assets/img/search.png" class="search-icon"  @click="handleSearch"/>
      <i style="color:rgb(9,93,227);font-size:12px;font-style:normal;">热门搜索：
        <a class="tag-item" @click="handleTopicDetail('苹果果树种植方法')">苹果果树种植方法 </a> <a class="tag-item" @click="handleTopicDetail('新疆哈密瓜甜度控制')">新疆哈密瓜甜度控制</a> <a class="tag-item" @click="handleTopicDetail('玉米苗灌溉')">玉米苗灌溉</a>
      </i>
    </div>
    <div class="goods" v-for="(item, index) in cgoods" :key="index">
      <div class="info">
        <p class="content">
          <i class="question-text" style="" v-if="item.status == 0">[问]</i>
          <i class="question-text" v-else>[答]</i>
          <span class="question-content" @click="handleDetail(item)">{{ item.title }}</span>
        </p>
        <div class="person-contents">
          <span>提问者：{{ item.questioner }}</span>&nbsp;&nbsp;&nbsp;
          <span>专家：{{ item.expertName }}</span>
        </div>
      </div>
    </div>
    <Pagination @item-click="pageClick" :cUrl="url" :cTotal="total" :cPageSize="pageSize"></Pagination>
  </div>
</template>

<script>
import Pagination from "./Pagination.vue";

export default {
  data() {
    return {
      searchValue:''
    };
  },
  components:{
    Pagination
  },
  filters: {
    formatTimer: function (value) {
      let date = new Date(value);
      let y = date.getFullYear();
      let MM = date.getMonth() + 1;
      MM = MM < 10 ? "0" + MM : MM;
      let d = date.getDate();
      d = d < 10 ? "0" + d : d;
      let h = date.getHours();
      h = h < 10 ? "0" + h : h;
      let m = date.getMinutes();
      m = m < 10 ? "0" + m : m;
      let s = date.getSeconds();
      s = s < 10 ? "0" + s : s;
      return y + "-" + MM + "-" + d + " ";
    },
  },
  props: {
    cgoods: {
      type: Array,
    },
    total:{
      type: Number
    },
    pageSize:{
      type: Number
    },
    url:{
      type: String
    }
  },
  methods: {
    detailsClick(item) {
      this.$store.commit("updateOrderId", item);
      this.$router.push(`/home/details?id=${item.id}`).catch((err) => err);
    },
    pageClick(val){
      this.$emit('pageClick',val)
    },
    handleSearch(){
      this.$emit('handleSearch',this.searchValue)
    },
    handleDetail(item){
      this.$router.push(`/home/guide/${item.id}`)
    },
    handleTopicDetail(val){
      this.searchValue = val
      this.handleSearch()
    }
  },
  mounted(){
    this.$store.commit("updateActiveIndex", "5");
  }
};
</script>

<style lang="less" scoped>
.search {
  width: 730px;
  height: 80px;
  background-color: white;
  padding: 10px 20px;
  .tag-item{
    margin-right: 8px;
    cursor: pointer;
  }
  .search-icon{
    position:relative;
    bottom:2px;
    left: -2px;
    cursor: pointer;
  }
}

.goods-box3 {
  width: 730px;
  .goods {
    width: 730px;
    min-height: 80px;
    padding: 10px 20px;
    background-color: white;
    border-radius: 0px;
    border-bottom: 1px solid #f2f2f2;

    .info {
      width: 685px;

      .title {
        /*超出的部分隐藏*/
        overflow: hidden;
        /*文字用省略号替代超出的部分*/
        text-overflow: ellipsis;
        /*弹性伸缩盒子模型显示*/
        display: -webkit-box;
        /*限制在一个块元素显示文本的行数*/
        -webkit-line-clamp: 1;
        /*设置或检索伸缩盒对象的子元素排列方式*/
        -webkit-box-orient: vertical;
      }

      .content {
        width: 680px;
        line-height: 20px;
        display: flex;
        flex-direction: row;
        justify-content: flex-start;
        align-items: center;
        /*超出的部分隐藏*/
        overflow: hidden;
        /*文字用省略号替代超出的部分*/
        text-overflow: ellipsis;
        /*弹性伸缩盒子模型显示*/
        display: -webkit-box;
        /*限制在一个块元素显示文本的行数*/
        -webkit-line-clamp: 7;
        /*设置或检索伸缩盒对象的子元素排列方式*/
        -webkit-box-orient: vertical;
        .question-text{
          color:#666;
          font-style:normal;
        }
      }
      .person-contents{
        display: flex;
        flex-direction: row;
        justify-content: flex-end;
        font-size: 12px;
        color: #666;
      }
      .price {
        font-size: 15px;
        font-weight: bold;
        display: block;
        color: red;
      }
    }
  }
}
.marginR5{
  margin-right: 5px;
}
.question-content{
  cursor: pointer;
  &:hover{
    text-decoration: underline;
    color: #035D1C;
  }
}
.search /deep/ .el-input--suffix .el-input__inner{
  height: 35px;
  line-height: 35px;
}
</style>