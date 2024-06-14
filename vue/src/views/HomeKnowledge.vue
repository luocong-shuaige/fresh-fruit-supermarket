<template>
  <div class="home-konwledges">
    <knowledge :cknowledges="knowledges"></knowledge>
    <pagination
      @item-click="pageClick"
      :cUrl="url"
      :cTotal="total"
      :cPageSize="pageSize"
    ></pagination>
  </div>
</template>

<script>
import { selectKnowledgesPage } from "../api/knowledge";
import Knowledge from "../components/Knowledge.vue";
import Pagination from "../components/Pagination.vue";
export default {
  data() {
    return {
      knowledges: [],
      total: 0,
      pageSize: 10,
      url: "/knowledge/",
      knowledgesCount: sessionStorage.getItem("/knowledge/pageCode")
        ? sessionStorage.getItem("/knowledge/pageCode")
        : 1,
    };
  },
  created() {
    this.$store.commit("updateActiveIndex", "4");
    selectKnowledgesPage({
      pageNum: this.knowledgesCount,
    }).then((res) => {
      if (res.flag == true) {
        let tmp = res.data.records;
        tmp.forEach(e => {
          const flieArr = e.picPath.split('.');
          e.type = flieArr[flieArr.length - 1]
        })
        this.knowledges = tmp;
        this.total = res.data.total;
      }
    });
  },
  methods: {
    pageClick(item) {
      this.knowledges = item;
    },
  },
  components: { Knowledge, Pagination },
};
</script>

<style>
</style>