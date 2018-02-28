<!DOCTYPE html>
<html>
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

        <main role="main" class="col-sm-9 ml-sm-auto col-md-10 pt-3">
          <router-view></router-view>
        </main>
      </div>
    </div>
    <template id="list">
    	<div>list</div>
    </template>
	<#include "/common/script.html"/> 
	<script src="https://unpkg.com/vue"></script>
	<script src="https://unpkg.com/vue-router@2.0.0/dist/vue-router.js"></script>
	<script type="text/javascript">
	    const NotFound = { template: '<p>Page not found</p>' }
	    const List = { template: '#list'}
	    const New = { template: '<div>new</div>' }
	    const Finished = { template: '<div>finished</div>' }
	    const Unfinished = { template: '<div>unfinished</div>' }
	    const Garbage = { template: '<div>garbage</div>' }
	    const routes = [
			{ path: '/list', component: List },
			{ path: '/new', component: New },
			{ path: '/finished', component: Finished },
			{ path: '/unfinished', component: Unfinished },
			{ path: '/garbage', component: Garbage },
	    ]

	    const router = new VueRouter({
	  	  routes
	  	})
	    
	    const app = new Vue({
	  	  router
	  	}).$mount('#app')
	  	

	
	</script>
	<script type="text/javascript">
	
	</script>
	
</body>
</html>