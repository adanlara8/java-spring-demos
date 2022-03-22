<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>All Wine Reviews</title>
	</head>
	<body>
		<h1>Wine List</h1>
		
		<a href= "/review-form">Add Review</a>
			
		<table>
			<thead>
				<tr>
					<td>Name</td>
					<td>Type</td>
					<td>Year</td>
					<td>Score</td>
					<td>Picture</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allWineReviewsByScore}" var= "wineReview">
					<tr>
						<td><a href="/wine-review/${wineReview.id}">${wineReview.name}</a></td>
						<td>${wineReview.type}</td>
						<td>${wineReview.year}</td>
						<td>${wineReview.score}</td>
						<td>${wineReview.picture}</td>
					</tr>
				</c:forEach>
			</tbody>					
		</table>
		

	</body>
</html>