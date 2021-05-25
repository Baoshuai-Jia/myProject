<template>
<h1>{{ title }}</h1>
<div>{{ content }}</div>
</template>

<script>
	export default {
	  name: 'test',
	  props: {
	    msg: String,
		default: 'test msg '
	  },
	  methods:{
		  
	  },
	  data() {
	  	return{
			
		}
	  }
	}
</script>

<style>
</style>
