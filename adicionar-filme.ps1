Write-Host "=== SCREENMATCH API - ADICIONAR FILMES DA OMDB ===" -ForegroundColor Green
Write-Host ""

$apiUrl = "https://scrennmatch-api.onrender.com/api/filmes/omdb"

while ($true) {
    Write-Host "Escreva o nome do filme que quer adicionar (ou 'sair' para encerrar): " -ForegroundColor Cyan -NoNewline
    $filme = Read-Host
    
    if ($filme -eq "sair" -or $filme -eq "") {
        Write-Host "Encerrando..." -ForegroundColor Yellow
        break
    }
    
    Write-Host "Buscando '$filme' na OMDb..." -ForegroundColor Yellow
    
    try {
        $resultado = Invoke-RestMethod -Method POST -Uri "$apiUrl/$filme" -ErrorAction Stop
        
        Write-Host ""
        Write-Host "Filme adicionado com sucesso!" -ForegroundColor Green
        Write-Host "ID: $($resultado.id)" -ForegroundColor White
        Write-Host "Titulo: $($resultado.titulo)" -ForegroundColor White
        Write-Host "Ano: $($resultado.ano)" -ForegroundColor White
        Write-Host "Diretor: $($resultado.diretor)" -ForegroundColor White
        Write-Host "Genero: $($resultado.genero)" -ForegroundColor White
        Write-Host ""
    }
    catch {
        Write-Host "Erro: Filme nao encontrado ou erro na API" -ForegroundColor Red
        Write-Host ""
    }
}
