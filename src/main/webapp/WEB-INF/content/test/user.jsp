<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<form accept-charset="UTF-8" role="form">
	<fieldset>
		<div class="form-group">
			<input class="form-control" placeholder="Username" name="username"
				type="text">
		</div>
		<div class="form-group">
			<input class="form-control" placeholder="Password" name="password"
				type="password" value="">
		</div>
		<div class="checkbox">
			<label> <input name="remember" type="checkbox"
				value="Remember Me"> bollean
			</label>
		</div>
		<input class="btn btn-primary " type="submit" value="Create">
	</fieldset>
</form>









<div class="panel panel-default">
<!--   <div class="panel-heading">Panel heading</div> -->
<table class="table table-striped table-bordered">
	<thead>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Parent ID</th>
			<th class="text-center">Action</th>
		</tr>
	</thead>
	<tr>
		<td>1</td>
		<td>News</td>
		<td>News Cate</td>
		<td class="text-center"><a class='btn btn-info btn-xs' href="#"><span
				class="glyphicon glyphicon-edit"></span> Edit</a> <a href="#"
			class="btn btn-danger btn-xs"><span
				class="glyphicon glyphicon-remove"></span> Del</a></td>
	</tr>
	<tr>
		<td>2</td>
		<td>Products</td>
		<td>Main Products</td>
		<td class="text-center"><a class='btn btn-info btn-xs' href="#"><span
				class="glyphicon glyphicon-edit"></span> Edit</a> <a href="#"
			class="btn btn-danger btn-xs"><span
				class="glyphicon glyphicon-remove"></span> Del</a></td>
	</tr>
	<tr>
		<td>3</td>
		<td>Blogs</td>
		<td>Parent Blogs</td>
		<td class="text-center"><a class='btn btn-info btn-xs' href="#"><span
				class="glyphicon glyphicon-edit"></span> Edit</a> <a href="#"
			class="btn btn-danger btn-xs"><span
				class="glyphicon glyphicon-remove"></span> Del</a></td>
	</tr>
</table>
</div>

