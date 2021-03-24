<%@ include file="../includes/header.jsp"%>
<div class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header card-header-primary">
						<h4 class="card-title ">Simple Table</h4>
						<p class="card-category">Here is a subtitle for this table</p>
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table">
								<thead class=" text-primary">
									<th>LOGO</th>
									<th>ID</th>
									<th>Email</th>
									<th>Phone</th>
									<th>Enabled</th>
									<th>Approval</th>
									<th>RegDate</th>
									<th>UpdateDate</th>
								</thead>
								<tbody class="tableList">
									
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			
		</div>
	</div>
</div>
<script type="text/javascript" src="/resources/service.js"></script>

<script>

const tableList = document.querySelector(".tableList")

service.sendList().then(res => res.json()).then(result => {
	for (let resultElement of result) {
		
		tableList.innerHTML += "<tr><td><img src= '"+resultElement.logoImg+"'></td>" +
		"<td onclick='sendRead("+JSON.stringify(resultElement.mid)+")'>"+resultElement.mid+"</td>" +
		"<td>"+resultElement.email+"</td>" +
		"<td>"+resultElement.phone+"</td>" +
		"<td>"+resultElement.enabled+"</td>" +
		"<td>"+resultElement.approval+"</td>" +
		"<td>"+resultElement.regdate+"</td>" +
		"<td>"+resultElement.updatedate+"</td></tr>"
	}
	
})

</script>

<script>



function sendRead(param){
	
	console.log(param)
	
	self.location="/manager/read/"+param
}

/* sendRead().then(result => {
	console.log(result)
}) */


</script>
<%@ include file="../includes/footer.jsp"%>