<template>
  <div class="needs-box">
    <div class="search3">
      <el-input v-model="searchValue" maxlength="100" clearable style="width:290px;"/>
      <img src="../assets/img/search.png" class="search-icon" @click="handleSearch"/>&nbsp;&nbsp;
        <i style="color:rgb(9,93,227);font-size:13px;font-style:normal;">&nbsp;热门搜索：
          <a class="tag-item" @click="handleTopicDetail('苹果')">苹果</a> 
          <a class="tag-item" @click="handleTopicDetail('新疆哈密瓜')">新疆哈密瓜</a>  
          <a class="tag-item" @click="handleTopicDetail('樱桃')">樱桃</a>  
          <a class="tag-item" @click="handleTopicDetail('西红柿')">西红柿</a>  
          <a class="tag-item" @click="handleTopicDetail('水稻')">水稻</a>  
          <a class="tag-item" @click="handleTopicDetail('玉米')">玉米</a>  
          <a class="tag-item" @click="handleTopicDetail('赣南脐橙')">赣南脐橙</a> 
        </i>
    </div>
    <div class="purchase-content">
      <div v-for="(item, index) in cneeds"
      :key="index" class="purchase-item"
      @click="detailsClick(item.orderId)">
        <div class="title">
          <span class="tips">{{item.type === 'needs'?'[求购]':''}}</span>
          <span class="title-content">{{item.content}}</span>
        </div>
        <div class="content">{{item.title}}</div>
        <div class="update-time">{{ item.updateTime | formatTimer}}</div>
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
        formatTimer: function(value) {
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
        }
      },
  props: {
    cneeds: {
      type: Array,
    },
  },
  methods: {
    detailsClick(item) {
      this.$store.state.orderId = item;
      this.$router.push(`/home/purchaseDetails?orderId=${item}`).catch((err) => err);
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

<style lang='less' scoped>
.needs-box{
  width: 100%;
  .search3 {
    height: 60px;
    background-color: white;
    padding: 10px 20px;
    margin: 10px auto;
    width: 1100px;
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
  .purchase-content{
    background: #fff;
    padding: 20px;
    width: 1100px;
    margin: 0 auto;
    .purchase-item{
      display: flex;
      flex-direction: row;
      justify-content: space-between;
      padding: 10px 0;
      border-bottom: 1px solid #eee;
      .title{
        width: 620px;
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
        .tips{
          color: #999;
        }
        .title-content{
          cursor: pointer;
          &:hover{
            color: #035D1C;
            text-decoration: underline;
          }
        }
      }
      .content{
        width: 300px;
        margin-left: 20px;
        /*超出的部分隐藏*/
        overflow: hidden;
        /*文字用省略号替代超出的部分*/
        text-overflow: ellipsis;
        /*弹性伸缩盒子模型显示*/
        display: -webkit-box;
        /*限制在一个块元素显示文本的行数*/
        -webkit-line-clamp: 1;
        /*设置或检索伸缩盒对象的子元 素排列方式*/
        -webkit-box-orient: vertical;
      }
      .update-time{
        width: 100px;
        text-align: right;
      }
    }
  }
}



.search3 /deep/ .el-input--suffix .el-input__inner{
  height: 35px;
  line-height: 35px;
}
</style>