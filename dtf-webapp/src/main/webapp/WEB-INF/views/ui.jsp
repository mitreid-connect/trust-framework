<%--
  Created by IntelliJ IDEA.
  User: bkeyes
  Date: 8/15/14
  Time: 1:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="TrustFramework">
<head>
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.2.0/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="resources/css/trust.css" />
    
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.20/angular.min.js"></script>
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/0.10.0/ui-bootstrap.min.js"></script>
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/0.10.0/ui-bootstrap-tpls.min.js"></script>
    <script type="text/javascript" src="resources/js/trust.js"></script>
    
    <title>Trust Framework</title>
</head>
<body ng-controller="TrustCtrl">
    <div class="row">
        <div class=".col-md-4">
            <span class="label label-danger">{{error}}</span>
        </div>
    </div>
    <div class="row">
        <div class=".col-md-1">Cards:</div>
        <div class=".col-md-4">
            <div class="btn-group" dropdown is-open="dropdown.isOpen">
                <button type="button" class="btn btn-primary dropdown-toggle" ng-disabled="disabled">
                    Select a Card<span class="caret"></span>
                </button>
                <ul class="cards dropdown-menu" role="menu">
                    <li class="card" ng-repeat="card in cards" ng-click="selectCard(card)">
                        <span>{{card.id}}: {{card.title}}</span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="row">
        <button type="button" class="btn btn-primary" ng-click="getCard()">Load!</button>
    </div>
    <div class="row">
        <span class="label label-info">{{selectedCard.dependencies}}</span>
    </div>
</body>
</html>
