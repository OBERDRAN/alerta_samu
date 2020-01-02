<?php
$url= "https://alerta-samu.herokuapp.com/Alertas";
$alertas = json_decode(file_get_contents($url));
?>
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body class="container">

    <h1>Alertas</h1>

    <table class="table table-striped">
        <thead class="thead-dark">
            <tr>
                <th>instante</th>
                <th>latitude</th>
                <th>longitude</th>
                <th>observação</th>
                <th>foto</th>
                <th>Atendimento</th>
                
            </tr>
        </thead>
        <tbody>
        <?php
        foreach($alertas as $Alerta){

            echo "<tr>";
               echo "<td>".date("d-m-Y H:i:s", strtotime($Alerta->instante))."</td>";
               echo "<td>$Alerta->latitude</td>";
               echo "<td>$Alerta->longitude</td>";
               echo "<td>$Alerta->observacao</td>";
               echo "<td></td>";
               echo "<td><a href='atendimentos-alertas.php'>atender</a></td>";
            echo  "</tr>";
        
        }
    ?>

        </tbody>
    </table>
</body>

</html>