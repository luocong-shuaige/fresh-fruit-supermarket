<template>
  <div class="goods-box2">
    <div class="search">
      <div>
        <el-input v-model="searchValue" maxlength="100" clearable style="width:290px;"/>
        <img src="../assets/img/search.png" @click="handleSearch" class="search-icon"/>
      </div>
      <div style="color:rgb(9,93,227);font-size:12px;margin-top: 10px;">
        热门搜索：
        <a class="tag-item" @click="handleTopicDetail('苹果')">苹果</a> 
        <a class="tag-item" @click="handleTopicDetail('新疆哈密瓜')">新疆哈密瓜</a>  
        <a class="tag-item" @click="handleTopicDetail('樱桃')">樱桃</a> 
      </div>
    </div>
    <div class="goods" v-for="(item, index) in cgoods" :key="index"
      @click="detailsClick(item.orderId)">
      <img v-if="item.picture" :src="$store.state.imgShowRoad + '/file/' + item.picture" class="goods-img" />
      <img v-else :src="$store.state.imgShowRoad + '/file/' + 'wutu.gif'" class="goods-img" />
      <div class="info">
        <p class="content">
          <i  style="color:rgb(9,93,227);font-size:12px;font-style:normal;" v-if="item.type == 'goods'">[供]</i>
          <i style="color:rgb(9,93,227);font-size:12px;font-style:normal;" v-else>[需]</i>
          <span class="content-text">{{ item.content }}</span>
        </p>
        <span class="price" v-if="item.price"><i style="font-size:5px">￥</i>{{ item.price }}</span>
        <span class="initiator">{{ item.ownName }} | {{ item.createTime | formatTimer}}</span>
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
      return y + "-" + MM + "-" + d + " " + h + ":" + m;
    },
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
.search {
  width: 624px;
  height: 80px;
  background-color: white;
  padding: 10px 20px;
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
.goods-box2 {
  background-color: #fff;
  width: 780px;
  margin: 0 auto;
  .goods {
    width: 780px;
    min-height: 120px;
    padding: 10px 20px;
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    background-color: white;
    border-radius: 0px;
    border-bottom: 1px solid #f2f2f2;
    .goods-img {
      width: 100px;
      height: 100px;
      margin-right: 20px;
      border-radius: 6px;
    }
    .info {
      width: 600px;
      .initiator {
        color: #666;
      }
      .content {
        width: 580px;
        line-height: 20px;
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
        font-size: 15px;
        display: flex;
        flex-direction: row;
        justify-content: flex-start;
        .content-text{
          cursor: pointer;
          &:hover{
            color: #035D1C;
            text-decoration: underline;
          }
        }
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
.search /deep/ .el-input--suffix .el-input__inner{
  height: 35px;
  line-height: 35px;
}
</style>