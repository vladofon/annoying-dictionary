import { api } from '@/api/api-resource'

export default {
	get: () => api.get('sessions/me', {withCredentials: true}),
}