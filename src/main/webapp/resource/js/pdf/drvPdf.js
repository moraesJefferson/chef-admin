function createPdfDrv(numDrv, logradouro, pontoReferencia, municipio, sentido, dataHora, tipoRecibo, tipificacao, numAit, placa, ufVeiculo, marcaModelo, tipoVeiculo, proprietarioNome, proprietarioCpf, condutorNome, condutorCpf, condutorCnh, odometro, combustivel, farois, piscas, lanternas, chaveRoda, macaco, triangulo, estepe, extintor, retrovisorInt, bancosDianteiros, bancosTraseiros, paraChoqueDianteiro, paraLamas, vidros, rodas, bateria){ 
	console.log(numDrv);
	console.log(1);
	console.log(logradouro);
	console.log(pontoReferencia);
	console.log(municipio);
	console.log(sentido);
	console.log(dataHora)
	console.log(tipoRecibo);
	console.log(tipificacao);
	console.log(numAit);
	console.log(2);
	console.log(placa);
	console.log(ufVeiculo);
	console.log(marcaModelo);
	console.log(tipoVeiculo);
	console.log(3);
	console.log(proprietarioNome);
	console.log(proprietarioCpf);
	console.log(condutorNome);
	console.log(condutorCpf);
	console.log(condutorCnh);
	console.log(4);
	console.log(odometro);
	console.log(combustivel);
	console.log(farois);
	console.log(piscas);
	console.log(lanternas);
	console.log(chaveRoda);
	console.log(macaco);
	console.log(triangulo);
	console.log(estepe);
	console.log(extintor);
	console.log(retrovisorInt);
	console.log(bancosDianteiros);
	console.log(bancosTraseiros);
	console.log(paraChoqueDianteiro);
	console.log(paraLamas);
	console.log(vidros);
	console.log(rodas);
	console.log(bateria);

}

function geraPdfDrv(numDrv, logradouro, pontoReferencia, municipio, sentido, dataHora, tipoRecibo, tipificacao, numAit, placa, ufVeiculo, marcaModelo, tipoVeiculo, proprietarioNome, proprietarioCpf, condutorNome, condutorCpf, condutorCnh, odometro, combustivel, farois, piscas, lanternas, chaveRoda, macaco, triangulo, estepe, extintor, retrovisorInt, bancosDianteiros, bancosTraseiros, paraChoqueDianteiro, paraLamas, vidros, rodas, bateria, descLotacao, enderecoLotacao, telefoneLotacao, orgaoDescricao, orgaoCodigo){ 
	var dd = 
	{
		content: 
		[
		{
			style: 'tableExample',
			table: 
			{
			    widths: [80, '*', '*','*'],
				body: 
				[
					[{rowSpan: 4, image: 'data:image/png;base64,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', width:80, height:80} , {colSpan:3, rowSpan: 4, alignment:'center', text: `${orgaoDescricao} - ${descLotacao}\nDOCUMENTO DE RECOLHIMENTO VEICULAR - DRV\nCÓDIGO DO ÓRGÃO AUTUADOR: ${orgaoCodigo}\n\nDRV ${numDrv}`}, '',''],
					['L2', '', '',''],
					['L3', '', '',''],
					['L4', '', '',''],	
				]
			}	
		},
		{
			style: 'tableExample',
			table: 
			{
			    widths: ['*'],
				body: 
				[
					[{colSpan:1, text: '01 - DADOS GERAIS', fillColor: '#b0bec5', border: [false, false, false, true]}],
					
					[[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Logradouro',italics:true}],[{text: logradouro, alignment:'center'}] ] },layout: 'noBorders'}],],

				]
			}
		},
		{
			style: 'tableExample',
			table: 
			{
			    widths: ['*', '*'],
				body: 
				[
					[[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Ponto de referência',italics:true}],[{text: pontoReferencia, alignment:'center'}] ] },layout: 'noBorders'}], 

					[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Município',italics:true}],[{text: municipio, alignment:'center'}] ] },layout: 'noBorders'}]],
				]
			}
		},
		{
			style: 'tableExample',
			table: 
			{
			    widths: ['*', '*'],
				body: 
				[
					[[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Sentido',italics:true}],[{text: sentido, alignment:'center'}] ] },layout: 'noBorders'}] ,

					[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Data/Hora',italics:true}],[{text: dataHora, alignment:'center'}] ] },layout: 'noBorders'}],], 
				]
			}
		},
		{
			style: 'tableExample',
			table: 
			{
			    widths: ['*', '*', '*'],
				body: 
				[
					[[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Tipo de recibo',italics:true}],[{text: tipoRecibo, alignment:'center'}] ] },layout: 'noBorders'}],
					
					[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Tipificação',italics:true}],[{text: tipificacao, alignment:'center'}] ] },layout: 'noBorders'}],
									
					[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Número do AIT',italics:true}],[{text:numAit, alignment:'center'}] ] },layout: 'noBorders'}],],
				]
			}
		},
		{
			style: 'tableExample',
			table: 
			{
			    widths: ['*', '*', '*'],
				body: 
				[
				    [{colSpan:3,text: '02 - VEÍCULO', fillColor: '#b0bec5', border: [false, false, false, true]},'','',],

					[[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Placa/UF',italics:true}],[{text:`${placa}/${ufVeiculo}`, alignment:'center'}] ] },layout: 'noBorders'}],
					
					[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Marca/Modelo',italics:true}],[{text: marcaModelo, alignment:'center'}] ] },layout: 'noBorders'}],
									
					[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Tipo de veículo',italics:true}],[{text: tipoVeiculo, alignment:'center'}] ] },layout: 'noBorders'}],],
				]
			}
		},
		{
			style: 'tableExample',
			table: 
			{
			    widths: ['*', 120],
				body: 
				[
					[{colSpan:2, text: '03 - CONDUTOR E PROPRIETÁRIO', fillColor: '#b0bec5', border: [false, false, false, true]},''],
					
					[ [{table: {widths: ['*'], heights:['*'],body: [[{text: 'Proprietário',italics:true}],[{text: proprietarioNome, alignment:'center'}] ] },layout: 'noBorders'}] ,

					[{table: {widths: ['*'], heights:['*'],body: [[{text: 'CPF/CNPJ',italics:true}],[{text: proprietarioCpf, alignment:'center'}] ] },layout: 'noBorders', border: [false, false, false, true]}, ], ],
				]
			}
		},
		{
			style: 'tableExample',
			table: 
			{
			    widths: ['*'],
				body: 
				[
					[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Condutor',italics:true}],[{text: condutorNome, alignment:'center'}] ] },layout: 'noBorders'}],
				]
			}
		},
		{
			style: 'tableExample',
			table: 
			{
			    widths: ['*', '*'],
				body: 
				[
					[[{table: {widths: ['*'], heights:['*'],body: [[{text: 'CPF',italics:true, }],[{text: condutorCpf, alignment:'center'}] ] },layout: 'noBorders'}], 
					
					[{table: {widths: ['*'], heights:['*'],body: [[{text: 'CNH',italics:true, }],[{text: condutorCnh, alignment:'center'}] ] },layout: 'noBorders'}],],

				]
			}
		},
		{
			style: 'tableExample',
			table: 
			{
			    widths: ['*', '*', '*'],
				body: 
				[
					[{colSpan:3, text: '04 - ESTADO DO VEÍCULO', fillColor: '#b0bec5', border: [false, false, false, true]},'',''],
					
					[[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Odômetro',italics:true}],[{text: odometro, alignment:'center'}] ] },layout: 'noBorders'}] ,

					[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Combustível',italics:true}],[{text: combustivel, alignment:'center'}] ] },layout: 'noBorders'}] ,

					[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Faróis',italics:true}],[{text: farois, alignment:'center'}] ] },layout: 'noBorders'}], ],

					[[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Piscas',italics:true}],[{text: piscas, alignment:'center'}] ] },layout: 'noBorders'}] ,
					
					[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Lanternas',italics:true}],[{text: lanternas, alignment:'center'}] ] },layout: 'noBorders'}] ,

					[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Chave de roda',italics:true}],[{text: chaveRoda, alignment:'center'}] ] },layout: 'noBorders'}], ],

					[[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Macaco',italics:true}],[{text: macaco, alignment:'center'}] ] },layout: 'noBorders'}] ,
	                
	                [{table: {widths: ['*'], heights:['*'],body: [[{text: 'Triângulo',italics:true}],[{text: triangulo, alignment:'center'}] ] },layout: 'noBorders'}] ,

					[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Estepe',italics:true}],[{text: estepe, alignment:'center'}] ] },layout: 'noBorders'}], ],

					[[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Extintor',italics:true}],[{text: extintor, alignment:'center'}] ] },layout: 'noBorders'}] ,
					
					[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Retrovisor int.',italics:true}],[{text: retrovisorInt, alignment:'center'}] ] },layout: 'noBorders'}] ,

					[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Bancos dianteiros',italics:true}],[{text: bancosDianteiros, alignment:'center'}] ] },layout: 'noBorders'}], ], 

					[[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Bancos traseiros',italics:true}],[{text: bancosTraseiros, alignment:'center'}] ] },layout: 'noBorders'}] ,
					
					[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Para choque dianteiro',italics:true}],[{text: paraChoqueDianteiro, alignment:'center'}] ] },layout: 'noBorders'}] ,

					[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Para lamas',italics:true}],[{text: paraLamas, alignment:'center'}] ] },layout: 'noBorders'}], ], 

					[[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Vidros',italics:true}],[{text: vidros, alignment:'center'}] ] },layout: 'noBorders'}] ,
					
					[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Rodas',italics:true}],[{text: rodas, alignment:'center'}] ] },layout: 'noBorders'}] ,

					[{table: {widths: ['*'], heights:['*'],body: [[{text: 'Bateria',italics:true}],[{text: bateria, alignment:'center'}] ] },layout: 'noBorders'}], ],

				]
			}
		},
		
		{
			style: 'tableExample',
			table: 
			{
			    widths: ['*'],
				body: 
				[
					[[{table: {widths: ['*'], heights:['*'],body: [[{text: 'OBSERVAÇÕES',italics:true, }],[{text:' ', alignment:'center'}] ] },layout: 'noBorders'}],], 
				]
			}
		}
		],
		
	}
	
	pdfMake.createPdf(dd).download(`DRV ${numDrv}.pdf`);
}