'use strict';

var hotspots;
if(window.localStorage.spots!=undefined)
    hotspots=JSON.parse(window.localStorage.spots);
else
    hotspots=[];
$.each(hotspots,function(i,val){
    val.title=val.name;
    val.description=val.name;
    val.price="￥1,000";
    val.image="../../assets/base/img/room.jpg";
    val.position= { top: val.top+'%', left: val.left+'%' }
});

var HotspotDetails = {
  name: 'HotspotDetails',
  template: '\n    <transition\n      name="detail"\n      @before-enter="beforeEnter"\n      @after-enter="afterEnter"\n      @before-leave="beforeLeave"\n    >\n      <div class="hotspot-details">\n        <a href="#" @click.prevent="close" class="hotspot-details__close">\n          <svg class="icon icon-close" viewBox="0 0 24 24">\n            <path d="M18.984 6.422l-5.578 5.578 5.578 5.578-1.406 1.406-5.578-5.578-5.578 5.578-1.406-1.406 5.578-5.578-5.578-5.578 1.406-1.406 5.578 5.578 5.578-5.578z"></path>\n          </svg>\n        </a>\n        <div class="hotspot-details__left">\n          <div class="hotspot-details__content">\n            <div class="carousel" ref="carousel">\n              <div class="carousel-cell" v-for="item in allItems">\n                <img :src="item.image" width="80%" />\n              </div>\n            </div>\n          </div>\n        </div>\n        <div class="hotspot-details__right">\n          <div class="hotspot-details__content">\n            <transition name="product-fade" mode="out-in">\n              <h3 class="hotspot-details__title animated" :key="selectedItem">{{ selectedItem.title }}</h3>\n            </transition>\n            <transition name="product-fade" mode="out-in">\n              <div class="hotspot-details__description animated" :key="selectedItem">{{ selectedItem.description }}</div>\n            </transition>\n            <transition name="product-fade" mode="out-in">\n              <div class="hotspot-details__price animated" :key="selectedItem">{{ selectedItem.price }}</div>\n            </transition>\n          </div>\n        </div>\n        <div class="hotspot-details__nav">\n          <a href="#" @click.prevent="selectProduct(index)" class="hotspot-details__nav-item" v-for="(item, index) in allItems">\n            <img :src="item.image" width="80%" />\n          </a>\n        </div>\n      </div>\n    </transition>\n  ',
  props: {
    item: { type: Object },
    selectedIndex: { type: Number },
    allItems: { type: Array }
  },
  data: function data() {
    return {
      selectedItem: this.item
    };
  },
  mounted: function mounted() {
    this.carousel = new Flickity(this.$refs.carousel, {
      cellAlign: 'left',
      contain: true,
      draggable: false,
      initialIndex: this.selectedIndex,
      imagesLoaded: true,
      prevNextButtons: false,
      pageDots: false
    });
    this.carousel.on('select', this.onProductSelected);
  },
  beforeDestroy: function beforeDestroy() {
    var _this = this;

    setTimeout(function () {
      _this.carousel.off('select', _this.onProductSelected);
      _this.carousel.destroy();
    }, 600);
  },

  methods: {
    close: function close() {
      this.$emit('close');
    },
    selectProduct: function selectProduct(index) {
      this.carousel.select(index);
    },
    onProductSelected: function onProductSelected() {
      this.selectedItem = this.allItems[this.carousel.selectedIndex];
    },
    beforeEnter: function beforeEnter(el) {
      el.style.setProperty('--top', this.item.position.top);
      el.style.setProperty('--left', this.item.position.left);
    },
    afterEnter: function afterEnter(el) {
      el.classList.add('is-loaded');
    },
    beforeLeave: function beforeLeave(el) {
      el.classList.remove('is-loaded');
    }
  }
};

var hotSpotApp = {
  name: 'app',
  components: {
    HotspotDetails: HotspotDetails
  },
  template: '\n    <div class="app" style="margin: auto">\n      <div class="image-hotspot" :class="{\'is-selected\': open }">\n        <hotspot-details \n          :item="selectedHotspot"\n          :selected-index="selectedIndex"\n          :all-items="hotspots"\n          @close="closeDetails"\n          v-if="open"\n        ></hotspot-details>\n        <transition-group name="hotspots">\n          <a \n            href="#" \n class="hotspot-point" \n v-for="(hotspot, index) in hotspotItems"\n  :style="{ top: hotspot.position.top, left: hotspot.position.left }"\n  @click.prevent="hotspotClicked(hotspot, index)"\n :key="index"\n >\n  <span :data-price="hotspot.price">\n  <svg class="icon icon-close" viewBox="0 0 24 24">\n                  <path d="M18.984 12.984h-6v6h-1.969v-6h-6v-1.969h6v-6h1.969v6h6v1.969z"></path>\n                </svg>\n              </span>\n          </a>\n        </transition-group>  \n        <img src="../../assets/base/img/room.jpg" alt="" @click="closeDetails">\n      </div>\n    </div>\n  ',
  data: function data() {
    return {
      hotspots: hotspots,
      open: false,
      hotspotPosition: null,
      selectedHotspot: null
    };
  },

  computed: {
    hotspotItems: function hotspotItems() {

      return this.open ? [] : this.hotspots;
    }
  },
  methods: {
    closeDetails: function closeDetails() {
      this.open = false;
    },
    hotspotClicked: function hotspotClicked(hotspot, index) {
      this.selectedHotspot = hotspot;
      this.selectedIndex = index;

      this.open = true;
    }
  }
};

new Vue({
  el: '#app',
  components: {
    App: hotSpotApp
  },
  render: function render(h) {
    return h(hotSpotApp);
  }
});