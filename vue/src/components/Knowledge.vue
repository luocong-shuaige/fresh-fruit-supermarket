<template>
  <div class="knowledge-box">
    <div class="knowledge" v-for="(item, index) in cknowledges" :key="index">
      <video class="knowledge-img" width="200px" height="160px" v-if="item.type==='mp4'||item.type==='MP4'" accept="MP4,mp4" :src="$store.state.imgShowRoad + '/file/' + item.picPath" controls autoplay/>
      <img v-else class="knowledge-img" :src="$store.state.imgShowRoad + '/file/' + item.picPath" alt="" />
      
      <div class="info">
        <h4 class="title" @click="handleDetail(item)">{{ item.title }}</h4>
        <p class="content">{{ item.content }}</p>
        <span class="initiator" style="color: rgb(9,93,227);">
          <img src="../assets/img/up-user.png" @click="handleDetail(item)"/>
          {{item.ownName}}
        </span>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    cknowledges: {
      type: Array,
    },
  },
  methods:{
    handleDetail(item){
      this.$router.push(`/home/knowledge/${item.knowledgeId}`)
    }
  }
};
</script>

<style lang="less" scoped>
.knowledge-box {
  width: 1100px;
  margin: 0 auto;
  background-color: #f6f6f6;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  flex-wrap: wrap;
  .knowledge {
    width: 500px;
    height: 200px;
    padding: 20px;
    border-radius: 10px;
    background-color: white;
    margin: 10px;
    video{
      border: 1px solid #f2f2f2;
      border-radius: 6px;
    }
    .knowledge-img {
      float: left;
      width: 200px;
      height: 160px;
      margin-right: 10px;
      border-radius: 6px;
    }
    .info {
      .title {
        font-weight: bold;
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
        cursor: pointer;
        &:hover{
          color: #035D1C;
          text-decoration: underline;
        }
      }
      width: 200px;
      float: left;
      .content {
        height: 100px;
        /*超出的部分隐藏*/
        overflow: hidden;
        /*文字用省略号替代超出的部分*/
        text-overflow: ellipsis;
        /*弹性伸缩盒子模型显示*/
        display: -webkit-box;
        /*限制在一个块元素显示文本的行数*/
        -webkit-line-clamp: 5;
        /*设置或检索伸缩盒对象的子元素排列方式*/
        -webkit-box-orient: vertical;
      }
      .initiator {
        color: #bfbfbf;
        img {
          margin: 0;
          padding: 0;
          width: 20px;
          height: 20px;
          margin-right: 10px;
          vertical-align: center;
          border-radius: 6px;
        }
      }
    }
  }
}
</style>