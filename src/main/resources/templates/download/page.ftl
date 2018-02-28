<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <#include "/common/head.html"/> 
    </head>
<body> 
	<header>
		<#include "/common/header.html"/>  
    </header>

    <div class="container-fluid" id="app">
      <div class="row">
        <nav class="col-sm-3 col-md-2 d-none d-sm-block bg-light sidebar">
          <ul class="nav nav-pills flex-column">
            <li class="nav-item">
              <router-link to="/list" active-class="active" tag="a" class="nav-link" exact>列    表</router-link>
            </li>
            <li class="nav-item">
              <router-link to="/new" active-class="active" tag="a" class="nav-link"  tag="a" >新    建</router-link>
            </li>
            <li class="nav-item">
              <router-link to="/finished" active-class="active" tag="a" class="nav-link" >已完成</router-link>
            </li>
            <li class="nav-item">
              <router-link to="/unfinished" active-class="active" tag="a" class="nav-link" >未完成</router-link>
            </li>
            <li class="nav-item">
              <router-link to="/garbage" active-class="active" tag="a" class="nav-link" >垃圾站</router-link>
            </li>
          </ul>
        </nav>

		<router-view></router-view>
        
      </div>
    </div>
    <!-- <template id="list">
    	<div>
    		list
    	</div>
		<script type="text/javascript">
			alert(1);
		</script>
    </template> -->
    
    <template id="new">
    	<main role="main" class="col-sm-9 ml-sm-auto col-md-10 pt-3">
	        <form action="/download/new/task" method="post">
	        	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			  <div class="form-group row">
			    <label for="inputUrl" class="col-sm-2 col-form-label">地址(URL)</label>
			    <div class="col-sm-9">
			      <input type="url" class="form-control is-valid" id="inputUrl" name="url" aria-describedby="urlHelp" placeholder="Enter http:// || https://">
			      <div class="invalid-feedback">
			        	非法链接
			      </div>
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="inputSort" class="col-sm-2 col-form-label">标签</label>
			    <div class="col-sm-8">
			      <input type="hidden" id="sortid" name="sortid">
			      <input type="text" readonly class="form-control-plaintext" id="inputSort" name="sorName">
			    </div>
			    <div class="col-auto">
			      <button type="button" class="btn btn-primary form-control">选择</button>
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="textarea1Introduction" class="col-sm-2 col-form-label">简介</label>
			    <div class="col-sm-9">
			      <textarea class="form-control is-valid" id="textarea1Introduction" name="introduction" rows="3">${urlerror!''}</textarea>
			    </div>
			  </div>
			  <button type="submit" class="btn btn-secondary btn-lg btn-block">提交</button>
			</form>
		</main>
    </template>
    
	<#include "/common/script.html"/> 
	<script src="https://unpkg.com/vue"></script>
	<script src="https://unpkg.com/vue-router@2.0.0/dist/vue-router.js"></script>
	<script type="text/javascript">
	    const NotFound = { template: '<p>Page not found</p>' }
	    
	    /* var all = {
	    	    items: [
	    	            { message: 'Foo' },
	    	            { message: 'Bar' }
	    	          ]
	    	        } */
	    	        
       var all = {
	    		data: [
	    		       {fileName:"apache"}
	    		      ]
	    };
	    
	   const List = {
		  template: '<main role="main" class="col-sm-9 ml-sm-auto col-md-10 pt-3">\
		  				<h2>下载排行</h2>\
		  				<div class="table-responsive">\
		  					<table class="table table-striped">'
		  						+'<thead><tr><th>序号</th><th>文件名</th><th>下载地址</th><th>分类</th><th>完成度</th></tr></thead>'
		  						+'<tbody>'
		  							+'<tr v-for="(item, index) in data">'
		  								+'<td>{{index+1}}</td><td>{{ item.fileName }}</td><td>{{ item.url }}</td><td>{{ item.sortid }}</td><td>{{ item.progress }}%</td>'
		  							+'</tr>'
		  						+'</tbody>'
		  					+'</table>'
		  				+'</div>'
		  				+'<nav aria-label="Page navigation example">'
						  +'<ul class="pagination justify-content-end">'
						    +'<li class="page-item disabled">'
						      +'<a class="page-link" href="#" tabindex="-1">Previous</a>'
						    +'</li>'
						    +'<li class="page-item"><a class="page-link" href="#">1</a></li>'
						    +'<li class="page-item"><a class="page-link" href="#">2</a></li>'
						    +'<li class="page-item"><a class="page-link" href="#">3</a></li>'
						    +'<li class="page-item">'
						      +'<a class="page-link" href="#">Next</a>'
						    +'</li>'
						  +'</ul>'
						+'</nav>'
		  			+'</main>',
		  					
		  data: function () {
			  return all
		  },
	      created: function () {
	    	  $.get("/download/task/list",function(res){
	    		  all.data = res;
	    	    });

	      }
		};
	    
	    const New = { template: '#new' }
	    const Finished = { template: '<div>finished</div>' }
	    const Unfinished = { template: '<div>unfinished</div>' }
	    const Garbage = { template: '<div>garbage</div>' }

	    const routes = [
			{ path: '/list', component: List },
			{ path: '/new', component: New },
			{ path: '/finished', component: Finished },
			{ path: '/unfinished', component: Unfinished },
			{ path: '/garbage', component: Garbage }
	    ]

	    const router = new VueRouter({
	  	  routes
	  	});
	    
	    const app = new Vue({
		  	  router
		  	}).$mount('#app')
	    
	  	
	  	var urlerror = "${urlerror!''}";
		if(urlerror){
			$("#inputUrl").removeClass("is-valid");
			$("#inputUrl").addClass("is-invalid");
		};
		
		$(function(){
			$("#inputUrl").on("mouseoff", function(){
				
			});
		});

	
	</script>
</body>
</html>