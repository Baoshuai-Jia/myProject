<template>
  <div>
    <span>{{msg}}</span>
    <div class="homeDiv" id="drag">
      <div class="iconClass" @dblclick="clickFunc" @mousedown="mousedown" @mousemove="mousemove" @mouseup="mouseup">
        <span class="spanClass">{{iconMsg}}</span>
      </div>
    </div>
  </div>
</template>

<script>
export default{
  name:'Mini',
  data(){
    return {
      msg:'图标按钮拖拽功能',
      iconMsg: '快来拖拽我～',

      dom: null,
      innerHeight: 0,
      innerWidth: 0,
      offsetHeight: 0,
      offsetWidth: 0,
      startX: 0,
      startY: 0,
      endX: 0,
      endY: 0,
      diffX: 0,
      diffY: 0,
      isDrag: false
    }
  },
  methods:{
    dragFunc(){
      this.dom = document.getElementById('drag');
      this.innerHeight= document.documentElement.clientHeight;
      this.innerWidth= document.documentElement.clientWidth;
      this.offsetHeight= this.dom.offsetHeight;
      this.offsetWidth=  this.dom.offsetWidth;
    },
    mousedown(e){
      this.isDrag= true;
      let et= e || window.event;
      this.startX= this.startY= et.clientX;
      this.endX= this.endY= et.clientY;
      this.diffY= et.clientY - this.dom.offsetTop;
      this.diffX= et.clientX - this.dom.offsetLeft;
      et.preventDefault();
    },
    mousemove(e){
      if(this.isDrag){
        let et= e || window.event;
        let currentX= et.clientX;
        let currentY= et.clientY;
        let my = currentY - this.diffY;
        let mx = currentX - this.diffX;
        let top,left;
        if(mx < 0){
          left= 0;
        }else if(mx > this.innerWidth - this.offsetWidth){
          left= this.innerWidth - this.offsetWidth;
        }else{
          left= mx;
        }
        if(my < 0){
          top= 0;
        }else if(my > this.innerHeight - this.offsetHeight){
          top= this.innerHeight - this.offsetHeight;
        }else{
          top= my;
        }
        this.dom.style.top= `${top}px`;
        this.dom.style.left= `${left}px`;
      }
    },
    mouseup(e){
      this.isDrag= false;
    },
    clickFunc(){
      console.log('快捷功能')
    }
  },
  mounted(){
    this.dragFunc();
  }
}

</script>

<style scoped>

</style>
