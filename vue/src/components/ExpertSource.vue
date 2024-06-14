<template>
  <div class="goods-box4">
    <div class="search" style="text-align:center">
      <el-input v-model="searchValue" maxlength="100" clearable style="width:290px;"/>
      <img src="../assets/img/search.png" @click="handleSearch" class="search-icon"/>
    </div>
    <div class="goods" v-for="(item, index) in cgoods" :style="index===cgoods.length-1?'':'border-bottom:1px solid #f2f2f2;'" :key="index">
      <!-- <img :src="$store.state.imgShowRoad + '/file/' + 'experta.png'" alt="" /> -->
      <div class="info">
        <p class="content">
          <span style="margin-right:50px;">专家姓名：{{item.realName}}</span>
          <span>职称：{{item.position}}</span>
        </p>
        <p class="content">
          <span>从事专业：{{item.profession}}</span>
          <span>联系电话：{{item.phone}}</span>
        </p>
        <p class="content">
          <span>单位：{{item.belong}}</span>
        </p>
      </div>
      <div class="info2">
        <span class="question-btn" @click="handleQuestion(item)" style="margin-right:20px;">向他提问</span>
        <span class="question-btn" @click="handleAppoint(item)">线下预约</span>
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
      this.$router.push("/home/details").catch((err) => err);
    },
    handleQuestion(item){
      this.$router.push(`/home/question?id=${item.userName}`).catch((err) => err);
    },
    handleAppoint(item){
      this.$router.push(`/home/appointment?id=${item.userName}`).catch((err) => err);
    },
    handleSearch(){
      this.$emit('handleSearch',this.searchValue)
    }
  },
};
</script>

<style lang="less" scoped>
.search {
  height: 60px;
  background-color: white;
  padding: 10px 20px;
  background-color: white;
  margin-top: 10px;
  .search-icon{
    position:relative;
    bottom:2px;
    left: -2px;
    cursor: pointer;
  }
}

.goods-box4 {
  background-color: #fff;
  width: 800px;
  margin: 0 auto;

  .goods {
    width: 800px;
    height: 110px;
    padding: 10px 20px;
    background-color: white;
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    align-items: center;
    img {
      width: 100px;
      height: 100px;
      margin-right: 20px;
      border-radius: 6px;
    }

    .info {
      width: 500px;
      margin-top: 10px;
      font-size: 14px;
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
        height: 20px;
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
      }

      .price {
        font-weight: bold;
        display: block;
        color: red;
      }
    }
  }
}
.info2{
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
  align-items: flex-end;
  .question-btn{
    cursor: pointer;
    color: rgb(9,93,227);
    &:hover{
      text-decoration: underline;
      color: rgb(3, 34, 83);
    }
  }
}
.search /deep/ .el-input--suffix .el-input__inner{
  height: 35px;
  line-height: 35px;
}
</style>