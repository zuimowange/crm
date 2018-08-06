console.log(CookieUtil.get("token"))
			//JavaScript代码区域
			layui.use('element', function() {
				var element = layui.element;
				var my_iframe_height = $(".layui-body").height();
				my_iframe_height -= 66;
				$(".my_iframe").height(my_iframe_height + 'px');
				
				/**
				 * 新增一个选项卡
				 */
				$(".link").click(function(){
					var lay_id = $(this).attr('lay-id');
					for(var i=0;i<$(".layui-tab-title li").length;i++){
						if($(".layui-tab-title li").eq(i).attr("lay-id") == lay_id){
							element.tabChange('demo', lay_id);
							return false;
						}
					}
					element.tabAdd('demo', {
				        title: $(this).attr('title') //用于演示
				        ,content: '<iframe class="my_iframe" src="'+$(this).attr('url')+'" frameborder="0" scrolling="no" width="100%" height="'+my_iframe_height+'px"></iframe>'
				        ,id: lay_id //实际使用一般是规定好的id，这里以时间戳模拟下
				      })
					element.tabChange('demo', lay_id);
				})
				
			});

			$(".link").click(function() {
				var my_link = $(this).attr("link");
				$("#my_iframe").attr("src", my_link);
			})

			$("#signOut").click(function() {
				CookieUtil.delete("token");
				location.href = "/user/login";
			})