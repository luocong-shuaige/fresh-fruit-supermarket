<template>
  <div class="goods-box">
    <div class="search2">
      <el-input v-model="searchValue" maxlength="100" clearable style="width:290px;"/>
      <img src="../assets/img/search.png" @click="handleSearch" class="search-icon" />
      <i style="color:rgb(9,93,227);font-size:13px;font-style:normal;">
        &nbsp;热门搜索：
        <a class="tag-item" @click="handleTopicDetail('苹果')">苹果</a> 
        <a class="tag-item" @click="handleTopicDetail('新疆哈密瓜')">新疆哈密瓜</a>  
        <a class="tag-item" @click="handleTopicDetail('樱桃')">樱桃</a>  
        <a class="tag-item" @click="handleTopicDetail('西红柿')">西红柿</a>  
        <a class="tag-item" @click="handleTopicDetail('水稻')">水稻</a>  
        <a class="tag-item" @click="handleTopicDetail('玉米')">玉米</a>  
        <a class="tag-item" @click="handleTopicDetail('赣南脐橙')">赣南脐橙</a> 
      </i>
    </div>
    <div class="goods" v-for="(item, index) in cgoods"
      :key="index" @click="detailsClick(item.orderId)" :style="(index+1)%5===0?'margin-right:0':'margin-right:25px;'">
      <img class="goods-img" v-if="item.picture!=''" :src="$store.state.imgShowRoad + '/file/' + item.picture" alt="" />
      <img class="goods-img" v-if="item.picture==''" :src="$store.state.imgShowRoad + '/file/' + 'wutu.gif'" alt="" />  
      <div class="info">
        <span class="initiator">[{{ item.ownName }}]</span>
        <p class="content">{{ item.content }}</p>
        <span class="price" v-if="item.price">￥{{ item.price }}</span>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      searchValue:''
    };
  },
  props: {
    cgoods: {
      type: Array,
    },
  },
  methods: {
    detailsClick(item) {
      this.$store.commit("updateOrderId", item);
      this.$router.push(`/home/details?orderId=${item}`).catch((err) => err);
    },
    handleSearch(){
      this.$emit('handleSearch',this.searchValue)
    },
    handleTopicDetail(val){
      this.searchValue = val
      this.handleSearch()
    }
  },
};
</script>

<style lang="less" scoped>
.search2 {
  height: 60px;
  background-color: white;
  padding: 10px 20px;
  background-color: white;
  margin-top: 10px;
  .tag-item{
    margin-right: 10px;
    cursor: pointer;
  }
  .search-icon{
    position:relative;
    bottom:2px;
    left: -2px;
    cursor: pointer;
  }
}
.goods-box {
  background-color: #f9f9f9;
  width: 1100px;
  margin: 0 auto;
  .goods {
    float: left;
    width: 200px;
    height: 290px;
    margin-top: 15px;
    padding: 15px;
    background-color: white;
    border: 1px solid #d3d3d3;
    cursor: pointer;
    .goods-img {
      float: left;
      width: 160px;
      height: 170px;
      margin-right: 10px;
      border-radius: 6px;
    }
    .info {
      width: 160px;
      float: left;
      .initiator {
        color: #666;
      }
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
        height: 50px;
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
        font-size: 10px;
      }
      .price {
        font-size: 10px;
        font-weight: bold;
        display: block;
        color: red;
      }
    }
  }
}
.search2 /deep/ .el-input--suffix .el-input__inner{
  height: 35px;
  line-height: 35px;
}
</style>