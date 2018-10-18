function checkAllfun(){
	/*alert("coming....");*/
	// 获取全选   input 节点
	var ckAll = document.getElementById("checkAll");
	// 列表复选框
	var checkItems = document.getElementsByName("checkItem");
				
	// 判断 这个 全选 节点 是否选中
	if(ckAll.checked==true){
					/*alert("选中了");*/
					
		for(var i=0;i<checkItems.length;i++){
			checkItems[i].checked = true;
		}
		}else{
		/*alert("取消了");*/
			for(var i=0;i<checkItems.length;i++){
				checkItems[i].checked = false;
			}
					
		}
}