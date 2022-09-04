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

  <div>
    
  </div>
</template>

<script>
import axios from 'axios';
import lib from "@/scripts/lib";

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