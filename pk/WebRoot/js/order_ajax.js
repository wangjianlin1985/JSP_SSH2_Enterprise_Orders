$(document).ready(function(){
	
	//1、异步加载Categories 电影类别
	$.ajax({
		url:"GetCategories.action",
		type:"post",
		dataType:"json",
		success:function(data){
			//得到返回的 Categories参数 ,并解析成JSON对象
			var result = JSON.parse(data.result);
			//生成option，添加到 select节点中
			$.each(result,function(i){
				$("<option value=" + result[i].categoryId + ">" 
				+ result[i].categoryName + "</option>").appendTo("#categories");
			});
		}
	});
	//2、按钮点击
	$("#btn").click(function(){
		var param = $("#signupform").serialize();
		t=setTimeout(function() {
		
		$.ajax({
			url:"order_ajax1.action",
			type:"post",
			data:param,
			//contentType:"application/json",
			dataType:"json",
			  beforeSend: function(XMLHttpRequest) {
  			$("#msg").text("正在计算...");
 			 },
			success:function(data){
			    
			      $("#msg").hide();
				$("#preCost").val(data.total);
			}
			},3000000)
		});
        /*
		$.getJSON("order_ajax1.action",
		{a:$("#signupform input[name=a]").val(),
		b:$("#signupform input[name=b]").val()
		},function(result){
		$("#tt").html(result.countt);
    	});*/
		
	});
});






