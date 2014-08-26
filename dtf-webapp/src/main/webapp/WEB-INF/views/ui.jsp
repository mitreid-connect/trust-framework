<%--
  User: bkeyes, wkim
  Date: 8/15/14
  Time: 1:07 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html ng-app="trustFramework">
<head>
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.2.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="resources/css/trust.css" />

<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.20/angular.js"></script>
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/0.10.0/ui-bootstrap.min.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/0.10.0/ui-bootstrap-tpls.min.js"></script>
<script type="text/javascript" src="resources/js/trust.js"></script>

<title>Trust Framework</title>
</head>

<body ng-controller="trustCtrl">
	<div>
		<div>
			<span class="label label-danger">{{error}}</span>
		</div>
	</div>

	<div>
		<button type="button" class="btn btn-default">
			Send Instance
		</button>
	</div>

	<div class="list-group">
		<div class="card" ng-repeat="card in instanceCards">
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
					<p>
						<span ng-repeat="tag in card.providesTags"> <span class="label label-warning">{{tag.name}}</span>
						</span> <br> Depends on: <br>
					<div class="dependencies btn-group btn-group-lg">

						<div class="btn-group" ng-repeat="dependency in card.dependencies">
							<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" ng-disabled="dependency.chosen">
								{{dependency.description}}<br> Required tags:
								<p>
									<span ng-repeat="tag in dependency.tags"> <span class="label label-warning">{{tag.name}}</span>
									</span>
							</button>
							<ul class="dropdown-menu" role="menu">
								<li class="candidateCard" ng-repeat="candidate in getCandidateCards(dependency)"
									ng-click="instanceCards.push(candidate); dependency.chosen=true">{{candidate.title}}</li>
							</ul>
						</div>

					</div>
				</div>

			</div>
		</div>
	</div>

</body>
</html>
