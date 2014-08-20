<%--
  User: bkeyes, wkim
  Date: 8/15/14
  Time: 1:07 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html ng-app="TrustFramework">
<head>
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.2.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="resources/css/trust.css" />

<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.20/angular.min.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/0.10.0/ui-bootstrap.min.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/0.10.0/ui-bootstrap-tpls.min.js"></script>
<script type="text/javascript" src="resources/js/trust.js"></script>

<title>Trust Framework</title>
</head>

<body ng-controller="TrustCtrl">
	<div>
		<div>
			<span class="label label-danger">{{error}}</span>
		</div>
	</div>

	<div class="list-group">
		<div class="card" ng-repeat="card in cards">
			<div class="panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">{{card.title}}</h3>

					<div class="btn-group-sm">
						<button type="button" class="btn btn-default" ng-click="businessTxt(card)">business</button>
						<button type="button" class="btn btn-default" ng-click="legalTxt(card)">legal</button>
						<button type="button" class="btn btn-default" ng-click="technicalTxt(card)">technical</button>
					</div>
				</div>
				<div class="panel-body">
					<div>{{card.currentTxt}}</div>
					<br> Provides:
					<div ng-repeat="tag in card.providesTags">{{tag.name}}</div>
					<br> Depends on: <br>
					<div class="dependencies btn-group btn-group-lg">

						<div class="btn-group" ng-repeat="dependency in card.dependencies">
							<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
								{{dependency.description}}<br>
								Required tags: 
								<div ng-repeat="tag in dependency.tags">
									{{tag.name}}
								</div>
							</button>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">Dropdown link</a></li>
								<li><a href="#">Dropdown link</a></li>
							</ul>
						</div>

					</div>
				</div>

			</div>
		</div>
	</div>

</body>
</html>
