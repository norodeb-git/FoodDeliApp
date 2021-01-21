package com.foodapp.foodapp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@Entity
@Table(name = "RESTAURANT")
@JsonIgnoreType
public class Restaurant implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RESTAURANT_ID")
	private int restaurantId;

	@Column(name = "RESTAURANT_NAME")
	private String restaurantName;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "RATING")
	private String rating;
	
	@OneToMany(mappedBy = "pk.restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<RestaurantMenuMap> restaurantMenuMaps;
	
	@OneToMany(mappedBy = "pk.restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CustomerRestaurantMap> customerRestaurantMaps;

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public List<RestaurantMenuMap> getRestaurantMenuMaps() {
		return restaurantMenuMaps;
	}

	public void setRestaurantMenuMaps(List<RestaurantMenuMap> restaurantMenuMaps) {
		this.restaurantMenuMaps = restaurantMenuMaps;
	}

	public List<CustomerRestaurantMap> getCustomerRestaurantMaps() {
		return customerRestaurantMaps;
	}

	public void setCustomerRestaurantMaps(List<CustomerRestaurantMap> customerRestaurantMaps) {
		this.customerRestaurantMaps = customerRestaurantMaps;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((customerRestaurantMaps == null) ? 0 : customerRestaurantMaps.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + restaurantId;
		result = prime * result + ((restaurantMenuMaps == null) ? 0 : restaurantMenuMaps.hashCode());
		result = prime * result + ((restaurantName == null) ? 0 : restaurantName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (customerRestaurantMaps == null) {
			if (other.customerRestaurantMaps != null)
				return false;
		} else if (!customerRestaurantMaps.equals(other.customerRestaurantMaps))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (restaurantId != other.restaurantId)
			return false;
		if (restaurantMenuMaps == null) {
			if (other.restaurantMenuMaps != null)
				return false;
		} else if (!restaurantMenuMaps.equals(other.restaurantMenuMaps))
			return false;
		if (restaurantName == null) {
			if (other.restaurantName != null)
				return false;
		} else if (!restaurantName.equals(other.restaurantName))
			return false;
		return true;
	}

}