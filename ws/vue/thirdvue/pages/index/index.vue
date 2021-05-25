<template>
	<view class="content">
		<myconponent title="hi" content =" test ..."></myconponent>
		<uni-number-box></uni-number-box>
		<uni-number-box v-model = "vModelValue" />
		<uni-number-box :min="0" :max="9"></uni-number-box>
		<uni-number-box @change="bindChange"></uni-number-box>
	</view>
</template>

<script>
	import myconponent from "../../components/uni-number-box/myconponent.vue"
	import UniNumberBox from "../../uni_modules/uni-number-box/components/uni-number-box/uni-number-box.vue"
	export default {
		data() {
			return {
				title: 'Hello'
			}
		},
		onLoad() {

		},
		methods: {

		},
		components:{
			myconponent,
			UniNumberBox
		}
	}
</script>

<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.logo {
		height: 200rpx;
		width: 200rpx;
		margin-top: 200rpx;
		margin-left: auto;
		margin-right: auto;
		margin-bottom: 50rpx;
	}

	.text-area {
		display: flex;
		justify-content: center;
	}

	.title {
		font-size: 36rpx;
		color: #8f8f94;
	}
</style>
