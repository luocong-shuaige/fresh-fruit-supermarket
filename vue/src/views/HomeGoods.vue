<!--商品货源-->
<template>
  <div class="home-goods">
    <goods-sourse :cgoods="goods" @handleSearch="handleSearch"></goods-sourse>
    <pagination @item-click="pageClick" :cUrl="url" :cTotal="total" :cPageSize="pageSize"></pagination>
  </div>
</template>

<script>
import { selectGoodsPage } from "../api/order";
import GoodsSourse from "../components/GoodsSource.vue";
import Pagination from "../components/Pagination.vue";
export default {
  data() {
    return {
      goods: [],
      total: 0,
      pageSize: 30,
      searchValue:'',
      url: "/order/goods/",
      goodsCount: sessionStorage.getItem("/order/goods/pageCode")
        ? sessionStorage.getItem("/order/goods/pageCode")
        : 1,
    };
  },
  mounted() {
    this.$store.commit("updateActiveIndex", "2");
    this.getData()
  },
  methods: {
    getData(){
      selectGoodsPage({
        pageNum: this.goodsCount,
        keys:this.searchValue
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
    pageClick(item) {
      this.goods = item;
    },
    handleSearch(val){
      this.searchValue = val
      this.getData()
    }
  },
  components: {
    Pagination,
    GoodsSourse,
  },
};
</script>

<style lang="less" scoped>
.home-goods {
  width: 1100px;
  margin: 0 auto;
}
</style>