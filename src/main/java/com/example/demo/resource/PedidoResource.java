package com.example.demo.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Pedido;

@RestController
@RequestMapping("pedidos")
public class PedidoResource {

	static List<Pedido> pedidos = new ArrayList<>();
	
	public static void instancia() {
		Pedido p0 = new Pedido();
		p0.setCodigo("1234");
		p0.setSituacao("TESTE");
		pedidos.add(p0);

		Pedido p1 = new Pedido();
		p1.setCodigo("1701");
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

		Pedido p4 = new Pedido();
		p4.setCodigo("0902");
		p4.setSituacao("TRANSITO");
		pedidos.add(p4);

		Pedido p5 = new Pedido();
		p5.setCodigo("1203");
		p5.setSituacao("CANCELADO");
		pedidos.add(p5);
	}
	

	@GetMapping
	public ResponseEntity<List<Pedido>> listar() {
		instancia();
		return ResponseEntity.ok(pedidos);
	}

	@GetMapping(value = "/atualizado")
	public ResponseEntity<List<Pedido>> listarAtualizado() {
		return ResponseEntity.ok(pedidos);
	}

	@PostMapping
	public ResponseEntity<Pedido> criar(@RequestBody Pedido pedido) {
		pedidos.add(pedido);
		return ResponseEntity.created(URI.create("pedidos/" + pedido.getCodigo())).body(pedido);
	}

	@DeleteMapping
	public void deletar(@RequestBody Pedido pedido) {
		pedidos.remove(pedido);
	}

	@PutMapping
	public ResponseEntity<Pedido> atualizar(@RequestBody Pedido pedido) {
		deletar(pedido);
		pedidos.add(pedido);
		return ResponseEntity.ok(pedido);
	}

}
