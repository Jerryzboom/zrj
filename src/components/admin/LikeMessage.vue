<template>
    <div id = "main" style = "width: 900px; height: 1200px;"></div>
  </template>
  
  <script lang = "ts" setup>
  import { onMounted, ref } from "vue"
  import * as echarts from 'echarts';
  import axios from "axios"
  const nums = ref([])
  onMounted(() => {
    axios( {
        method : "post",
        url : "/ClerverClass_war/likeByVideoResourceLoading",
        data : {
          type : "echarts"
        },
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        }).then(res => {
          let l = res.data.length
          for(let i = 0; i < l; i += 1) {
            let mp = {}
            if(res.data[i].atNameLike > 0) {
              mp["name"] = res.data[i].atName 
              mp["value"] = res.data[i].atNameLike
              console.log(mp)
              nums.value.push(mp)
            }
            let voTitle = res.data[i][0];
            let s = res.data[i][1];
            if(s > 0) {
              mp["name"] = voTitle
              mp["value"] = s
              nums.value.push(mp)
            }
          }
          console.log(nums.value)
          var chartDom = document.getElementById('main');
      var myChart = echarts.init(chartDom);
  
      var option = {
        title: {
          text: 'Referer of a Website',
          subtext: 'Fake Data',
          left: 'center'
        },
        tooltip: {
          trigger: 'item'
        },
        legend: {
          orient: 'vertical',
          left: 'left'
        },
        series: [
          {
            name: 'Access From',
            type: 'pie',
            radius: '50%',
            center : ['50%', '50%'],
            data: nums.value,
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      };
      myChart.setOption(option);
        })
  })
  </script>
  