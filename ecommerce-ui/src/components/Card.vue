<template>
  <div class="card shadow-sm">
    <span class="img"/>
    <img :src="item.imgPath" />

    <div class="card-body">
      <p class="card-text">
        {{ item.name }}
      </p>
      <div class="d-flex justify-content-between align-items-center">
        <button class="btn btn-primary" @click="addToCart(item.id)">
          <i class="fa fa-shopping-cart" aria-hidden="true"></i>
        </button>

        <small class="price text-muted">
          {{ item.price }}원
        </small>
        <small class="discount text-danger text-muted">
          {{ item.discountPer }}%
        </small>

      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import lib from "@/scripts/lib";
import * as _ from 'lodash';

export default {
  name: "Card",
  props: {
    item: Object,
  },
  setup() {
    const addToCart = (itemId) => {
      axios.post(`/api/cart/items/${itemId}`).then(() => {
        console.log("success");
      });
    };
    return { lib, addToCart };
  },
  methods: {
    executePayment(paymentType) {

      // if (paymentType === "KAKAO_PAYMENT") {
      //   this.payOnKakao();
      // } else if (paymentType === "NAVER_PAYMENT") {
      //   this.payOnNaver();
      // } else if (paymentType === "COUPANG_PAYMENT") {
      //   this.payOnCoupang();
      // } else if (paymentType === "PAYCO_PAYMENT") {
      //   this.payOnCoupang();
      // } else if (paymentType === "APPLE_PAYMENT") {
      //   this.payOnCoupang();
      // }

      // const paymentMap = {
      //   KAKAO_PAYMENT() {
      //     this.payOnKakao();
      //   }
      //   ,NAVER_PAYMENT() {
      //     this.payOnNaver();
      //   }
      //   ,COUPANG_PAYMENT() {
      //     this.payOnCoupang();
      //   }
      //   ,PAYCO_PAYMENT() {
      //     this.payOnPayco();
      //   }
      //   ,APPLE_PAYMENT() {
      //     this.payOnApple();
      //   }
      // }
      
      const methodName = _.camelCase("payOn" + paymentType);
      const paymentMap = {
        [paymentType + "_PAYMENT"]() {
          this[methodName]();
        }
      }

      paymentMap[paymentType]();
      // this.executePayment("KAKAO_PAYMENT");
    }
    ,payOnCoupang() {

    }
    ,payOnNaver() {

    }
    ,payOnCoupang() {

    }
    ,payOnPayco() {

    }
    ,payOnApple() {

    }
  }
};
</script>

<style scoped>
.card .img {
  display: inline-block;
  width: 100%;
  height: 250px;
  background-size: cover;
  background-position: center;
}
.card .card-body .price {
  text-decoration: line-through;
}
</style>