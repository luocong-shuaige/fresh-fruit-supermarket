import Vue from 'vue'
import VueRouter from 'vue-router'

import Login from '../views/Login'
import Register from '../views/Register'
import Home from '../views/Home'
import HomeGoods from '../views/HomeGoods'
import HomePurchase from '../views/HomePurchase'
import HomeKnowledge from '../views/HomeKnowledge'
import KnowledgeDetail from '../views/KnowledgeDetail'
import ShopCart from '../views/ShopCart'
import Payment from '../views/Payment'
import Details from '../views/Details'
import purchaseDetails from '../views/purchaseDetails'
import User from '../views/User'
import UserInfo from '../views/UserInfo'
import UserAddress from '../views/UserAddress'
import UserPassword from '../views/UserPassword'
import PublishNav from '../components/PublishNav.vue'
import PublishGoods from '../views/PublishGoods'
import PublishNeeds from '../views/PublishNeeds'
import PublishKnowledges from '../views/PublishKnowledges'
import PublishedGoods from '../views/PublishedGoods'
import PublishedNeeds from '../views/PublishedNeeds'
import PublishedGoodsAdmin from '../views/PublishedGoodsAdmin'
import PublishedNeedsAdmin from '../views/PublishedNeedsAdmin'
import PublishedKnowledges from '../views/PublishedKnowledges'
import UserBuy from '../views/UserBuy'
import UserSell from '../views/UserSell'
import expertQuestion from '../views/expertQuestion'
import expertAppoint from '../views/expertAppoint'
import expertInfo from '../components/expertInfo.vue'
import UserManage from '../views/UserManage'
import FrontPage from '../views/FrontPage'
import HomeGuide from '../views/HomeGuide'
import guideDetail from '../views/guideDetail'
import AllExpert from '../views/AllExpert'
import question from '../views/Question'
import appointment from '../views/Appointment'
import Financing from '../views/Financing'
import SmartMatch from '../views/SmartMatch'
import FinancingDetails from '../views/FinancingDetails'
import userGood from '../views/goodsManager.vue'

Vue.use(VueRouter)


// 解决ElementUI导航栏中的vue-router在3.0版本以上重复点菜单报错问题
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

const routes = [
  {
    path: '/',
    redirect: '/home'
  },
  {
    path: '/home',
    component: Home,
    children: [
      {
        path: '',
        redirect: 'front'
      },
      {
        path: 'front',
        component: FrontPage
      },
      {
        path: 'goods',
        component: HomeGoods
      },
      {
        path: 'purchase',
        component: HomePurchase
      },
      {
        path: 'knowledge',
        component: HomeKnowledge
      },
      {
        path: 'knowledge/:id',
        component: KnowledgeDetail
      },
      {
        path: 'guide',
        component: HomeGuide
      },
      {
        path: 'guide/:id',
        component: guideDetail
      },
      {
        path: 'allExpert',
        component: AllExpert
      },
      {
        path: 'question',
        component: question
      },
      {
        path: 'appointment',
        component: appointment
      },
      {
        path: 'shopcart',
        component: ShopCart
      },
      {
        path: 'financing',
        component: Financing
      },
      {
        path: 'smartMatch',
        component: SmartMatch
      },
      {
        path: 'details',
        component: Details,
      },
      {
        path: 'purchaseDetails',
        component: purchaseDetails,
      },
      {
        path: 'financingDetails',
        component: FinancingDetails,
      },
      {
        path: 'user',
        component: User,
        children: [
          {
            path: '',
            redirect: 'userinfo'
          },
          {
            path: 'userinfo',
            component: UserInfo

          },
          {
            path: 'useraddress',
            component: UserAddress
          },
          {
            path: 'userpassword',
            component: UserPassword
          },
          {
            path: 'publishedgoods',
            component: PublishedGoods
          },
          {
            path: 'publishedneedsAdmin',
            component: PublishedNeedsAdmin
          }, 
          {
            path: 'publishedknowledges',
            component: PublishedKnowledges
          },
          {
            path: 'userbuy',
            component: UserBuy
          },
          {
            path: 'usersell',
            component: UserSell
          },
          {
            path: 'expertQuestion',
            component: expertQuestion
          },
          {
            path: 'expertAppoint',
            component: expertAppoint
          },
          {
            path:'expertInfo',
            component: expertInfo
          },
          // {
          //   path: 'publishedgoodsAdmin',
          //   component: PublishedGoodsAdmin
          // },
          {
            path: 'publishedneeds',
            component: PublishedNeeds
          },
        ]
      },
      {
        path:'userGood',
        component:userGood,
        children:[{
          path: 'publishedgoodsAdmin',
          component: PublishedGoodsAdmin
        },{
          path: 'PublishedNeedsAdmin',
          component: PublishedNeedsAdmin
        },]
      },
      {
        path: 'addmessage',
        component: PublishNav,
        children: [
          // {
          //   path: '',
          //   redirect: 'publishgoods'
          // },
          {
            path: 'publishgoods',
            component: PublishGoods
          }, {
            path: 'publishneeds',
            component: PublishNeeds
          },
          {
            path: 'publishknowledges',
            component: PublishKnowledges
          }

        ]
      },{
        path: 'usermanage',
        component: UserManage
      },
    ]
  },
  {
    path: '/payment',
    component: Payment
  },
  {
    path: '/login',
    component: Login
  },
  {
    path: '/register',
    component: Register
  }
]

const router = new VueRouter({
  routes,
  mode: 'hash',
})

export default router
