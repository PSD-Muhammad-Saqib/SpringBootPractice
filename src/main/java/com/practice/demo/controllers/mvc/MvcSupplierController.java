package com.practice.demo.controllers.mvc;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.demo.helpers.SupplierMVCPaths;
import com.practice.demo.models.Supplier;
import com.practice.demo.services.SupplierService;

@Controller
@RequestMapping("suppliers")
public class MvcSupplierController {

	@Autowired
	private SupplierService supplierService;

	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("supplier", new Supplier());
		return SupplierMVCPaths.getSaveSupplierPath();
	}

	@GetMapping("edit/{id}")
	public String update(Model model, @PathVariable(name = "id", required = true) Integer id) {
		Supplier supplier = supplierService.getById(id);

		if (Objects.isNull(supplier)) {
			model.addAttribute("error", "Errors");
			return SupplierMVCPaths.redirect();
		} else {
			model.addAttribute("supplier", supplier);
			return SupplierMVCPaths.getSaveSupplierPath();
		}
	}

	@PostMapping("save")
	public String save(Model model, @Validated Supplier supplier) {
		if (Objects.isNull(supplier.getId())) {
			Supplier saved = supplierService.save(supplier);
			
			if (Objects.isNull(saved)) {
				model.addAttribute("error", "Errors");
				return SupplierMVCPaths.redirect();
			} else {
				model.addAttribute("saved", true);
				return SupplierMVCPaths.redirect(saved.getId());
			}
		} else {
			Supplier updated = supplierService.update(supplier.getId(), supplier);

			if (Objects.isNull(updated)) {
				model.addAttribute("error", "Errors");
			}
			return SupplierMVCPaths.redirect(updated.getId());
		}
	}

	@GetMapping("/{id}")
	public String get(Model model, @PathVariable(name = "id", required = true) Integer id) {
		Supplier supplier = supplierService.getById(id);

		if (Objects.isNull(supplier)) {
			return SupplierMVCPaths.redirect();
		} else {
			model.addAttribute("supplier", supplier);
			return SupplierMVCPaths.getViewSupplierPath();
		}
	}

	@GetMapping(value = { "", "/" })
	public String getAll(Model model, @RequestParam(required = false, name = "query") String query) {
//		if (Objects.isNull(query)) {
//			return ResponseEntity.ok(supplierService.getAll());
//		}
		model.addAttribute("suppliers", supplierService.getAll());

		return SupplierMVCPaths.getAllSuppliersPath();
	}


	@GetMapping("delete/{id}")
	public String delete(Model model, @PathVariable(name = "id", required = true) Integer id) {
		Supplier supplier = supplierService.getById(id);

		if (Objects.isNull(supplier)) {
			model.addAttribute("error", "Errors");
		} else {
			Boolean res = supplierService.delete(id);
			model.addAttribute("success", res);
		}
		return SupplierMVCPaths.redirect();
	}

}
