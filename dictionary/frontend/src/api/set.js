import { api } from '@/api/api-resource'

export default {
	create: set => api.post('sets', set, {withCredentials: true}),
	edit: set => api.put(`sets/${set.id}`, set, {withCredentials: true}),
	list: () => api.get('sets', {withCredentials: true}),
	listByUser: id => api.get(`sets/user/${id}`, {withCredentials: true}),
	get: id => api.get(`sets/${id}`, {withCredentials: true}),
	getByTitle: title => api.get(`sets/find/${title}`, {withCredentials: true}),
	delete: id => api.delete(`sets/${id}`, {withCredentials: true}),
	setDefault: id => api.put(`sets/${id}/default`, {withCredentials: true}),
}