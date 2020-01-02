<?php
$url= "https://alerta-samu.herokuapp.com/Atendimentos";
$atendimentos = json_decode(file_get_contents($url));
?>
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body class="container">

    <h1>Atendimentos</h1>

    <table class="table table-striped">
        <thead class="thead-dark">
            <tr>
                <th>id</th>
                <th>observacaoadm</th>
                <th>status</th>
                <th>userSamu</th>
            </tr>
        </thead>
        <tbody>
            <?php

                foreach($atendimentos as $Atendimento)
                {
                    echo "<tr>";

                        echo "<td>$Atendimento->id</td>";
                        echo "<td>$Atendimento->observacaoadm</td>";
                        echo "<td>$Atendimento->status</td>";
                        echo "<td>$Atendimento->userSamu</td>";

                    echo  "</tr>";
                
                }
            ?>
        
        </tbody>
    </table>
</body>

</html>