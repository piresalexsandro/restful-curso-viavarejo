package com.example.demo.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Pedido;

@RestController("pedidos")
public class PedidoResource {

	List<Pedido> pedidos = new ArrayList<>();
	
	//http://localhost:8080/pedido
	@GetMapping	
	public ResponseEntity<List<Pedido>> listar() {
		Pedido p1 = new Pedido();
		p1.setCodigo("1809");
		p1.setSituacao("PENDENTE");
		pedidos.add(p1);
		
		Pedido p2 = new Pedido();
		p2.setCodigo("2611");
		p2.setSituacao("PAGO");
		pedidos.add(p2);
		
		Pedido p3 = new Pedido();
		p3.setCodigo("1910");
		p3.setSituacao("ENTREGUE");
		pedidos.add(p3);
		
	//	System.out.println("Teste");
		
		return ResponseEntity.ok(pedidos);
	}
	
	@PostMapping
	public ResponseEntity<Pedido> criar(@RequestBody Pedido pedido){
		pedidos.add(pedido);
		return ResponseEntity.created(URI.create("pedidos/" + pedido.getCodigo())).body(pedido);
	}
	
}
