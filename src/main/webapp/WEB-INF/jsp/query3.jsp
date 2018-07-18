<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Title</title>
</head>
<body>
<H1> <a href="/">Query 3</a></H1>
<br>
<div>
    <table border="5">
        <tr>
            <th>Count</th>
            <th>id form</th>
        </tr>
        <c:forEach items="${persons}" var="persone">
            <tr>
                <th>"${persone.count}"</th>
                <th>"${persone.formid}"</th>
            </tr>
        </c:forEach>
    </table>
</div>
<a href="/">back</a>
</body>
</html>