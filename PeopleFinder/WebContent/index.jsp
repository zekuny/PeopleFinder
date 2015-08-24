<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src = "validationForm.js"></script>
<title>Zekun</title>
</head>
<body>
<h2>Welcome to HR system!</h2>
<h2>Enter the person's last name in the text box below: </h2>
<form name = "myForm" class="form-horizontal" method="post" action="finderServlet" onsubmit="return validateForm()">
    <div class="form-group">
        <label for="Assignment" class="col-sm-2 control-label">Last Name</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="lastname" name="lastname" value="">
        </div>
    </div>
        <div class="form-group">
        <div class="col-sm-4 col-sm-offset-2">
            <input id="submit" name="submit" type="submit" value="Search" class="btn btn-primary">
        </div>
    </div>
</form>
<h2>Or</h2>
<h2>Enter the person's Company Name in the text box below: </h2>
<form name = "myForm" class="form-horizontal" method="post" action="finderServlet" onsubmit="return validateForm()">
    <div class="form-group">
        <label for="Assignment" class="col-sm-2 control-label">Company Name</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="companyname" name="companyname" value="">
        </div>
    </div>
        <div class="form-group">
        <div class="col-sm-4 col-sm-offset-2">
            <input id="submit" name="submit" type="submit" value="Search" class="btn btn-primary">
        </div>
    </div>
</form>
<br>
${table}
</body>
</html>